package test.local.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.local.demo.DTO.CourseCommentDTO;
import test.local.demo.DTO.TeacherCommentDTO;
import test.local.demo.DTO.VoteDTO;
import test.local.demo.entity.Activity;
import test.local.demo.entity.Authority;
import test.local.demo.entity.User;
import test.local.demo.mapper.ActivityMapper;
import test.local.demo.mapper.AuthorityMapper;
import test.local.demo.mapper.UserMapper;
import test.local.demo.service.UserService;

/**
 * @author 张娟娟
 * @date 2019/9/25 3:48 PM
 */
@Controller
public class UserController {

  @Autowired private UserMapper userMapper;
  @Autowired private AuthorityMapper authorityMapper;
  @Autowired private ActivityMapper activityMapper;
  @Autowired private UserService userService;

  @GetMapping(value = "/")
  public String home() {
    return "index";
  }

  // Login form
  @GetMapping("/login")
  public String login(Model model, @RequestParam(value = "error", required = false) String error) {
    if (error != null) {
      model.addAttribute("loginError", true);
    }
    return "login";
  }

  @GetMapping("/signIn")
  public String signIn() {
    return "signIn";
  }

  @PostMapping("/signIn")
  public String reg(String username, String password) {
    userMapper.insert(new User(username, new BCryptPasswordEncoder().encode(password), true));
    authorityMapper.insert(new Authority(username, "ROLE_USER"));
    return "redirect:/login";
  }

  @GetMapping(value = "/person/{username}/activities/course")
  public String courseCommentActivity(@PathVariable String username, Model model) {
    ArrayList<CourseCommentDTO> courseComments = userService.getCourseCommentByUser(username);
    model.addAttribute("courseComments", courseComments);
    return "activities";
  }

  @GetMapping(value = "/person/{username}/activities/teacher")
  public String teacherCommentActivity(@PathVariable String username, Model model) {
    ArrayList<TeacherCommentDTO> teacherComments = userService.getTeacherCommentByUser(username);
    model.addAttribute("teacherComments", teacherComments);
    return "activities";
  }

  @GetMapping(value = "/person/{username}/activities/vote")
  public String voteActivity(@PathVariable String username, Model model) {
    ArrayList<VoteDTO> votes = userService.getVoteByUser(username);
    model.addAttribute("votes", votes);
    return "activities";
  }

  @GetMapping(value = "/person/{username}/activities")
  public String myPerson(Model model, @PathVariable String username) {
    ArrayList<Activity> activities = (ArrayList<Activity>) activityMapper.myselectAll();
    model.addAttribute("activities", activities);
    return "activities";
  }

  @PostMapping(value = "/person/{username}/activities")
  public String activity(@PathVariable String username, String title, String content) {
    String time = new Date().toString();
    Activity activity = new Activity(username, title, content, time);
    activityMapper.insert(activity);
    return "redirect:/person/" + username + "/activities/";
  }
}
