package test.local.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import test.local.demo.DTO.CourseDTO;
import test.local.demo.entity.Course;
import test.local.demo.entity.CourseComment;
import test.local.demo.entity.CourseVote;
import test.local.demo.mapper.CourseCommentMapper;
import test.local.demo.mapper.CourseDTOMapper;
import test.local.demo.mapper.CourseMapper;
import test.local.demo.mapper.CourseVoteMapper;
import test.local.demo.mapper.TeacherMapper;

/**
 * @author 张娟娟
 * @date 2019/10/9 9:25 PM
 */
@Controller
public class CourseController {

  @Autowired private CourseMapper courseMapper;
  @Autowired private CourseDTOMapper courseDTOMapper;
  @Autowired private TeacherMapper teacherMapper;
  @Autowired private CourseCommentMapper courseCommentMapper;
  @Autowired private CourseVoteMapper courseVoteMapper;

  @GetMapping(value = "/course")
  public String course(
      Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
    PageHelper.startPage(pageNum, 3);
    PageInfo<CourseDTO> pageInfo = new PageInfo(courseDTOMapper.selectAll());
    model.addAttribute("pageInfos", pageInfo);
    return "course";
  }

  @GetMapping(value = "/course/detail/{id}")
  public String courseDetail(
      Model model,
      @SessionAttribute UserDetails userDetail,
      @PathVariable String id,
      @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
    if (courseVoteMapper.voteCheck(Integer.parseInt(id), userDetail.getUsername()) != null) {
      model.addAttribute("voted", true);
    }
    PageHelper.startPage(pageNum, 3);
    PageInfo<CourseComment> pageInfo =
        new PageInfo<>(courseCommentMapper.findByCourseId(Integer.parseInt(id)));
    model.addAttribute("pageInfos", pageInfo);
    model.addAttribute("course", courseDTOMapper.findById(Integer.parseInt(id)));
    return "course_detail";
  }

  @GetMapping(value = "/course/new")
  public String courseForm(Model model) {
    model.addAttribute("teachers", teacherMapper.getAll());
    return "course_form";
  }

  @PostMapping(value = "/course/new")
  public String newCourse(Model model, String name, int teacherId, String introduction) {
    int res = courseMapper.insert(new Course(name, teacherId, introduction));
    if (res <= 0) {
      model.addAttribute("courseCreateError", true);
    }
    return "redirect:/course";
  }

  @GetMapping(value = "/rank")
  public String rank(Model model) {
    model.addAttribute("courses", courseDTOMapper.selectRank());
    return "rank";
  }

  @PostMapping(value = "/course/comment/")
  public String courseComment(String courseId, String username, String content) {
    String time = new Date().toString();
    courseCommentMapper.insert(
        new CourseComment(username, Integer.parseInt(courseId), time, content));

    return "redirect:/course/detail/" + courseId;
  }

  @PostMapping(value = "/course/vote")
  public String courseVote(int courseId, @SessionAttribute UserDetails userDetail) {
    String username = userDetail.getUsername();
    if (courseVoteMapper.voteCheck(courseId, username) == null) {
      courseVoteMapper.insert(new CourseVote(courseId, username));
      courseMapper.updateLike(courseId);
    }
    return "redirect:/course/detail/" + courseId;
  }
}
