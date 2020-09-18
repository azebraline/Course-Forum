package test.local.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test.local.demo.entity.Teacher;
import test.local.demo.entity.TeacherComment;
import test.local.demo.mapper.TeacherCommentMapper;
import test.local.demo.mapper.TeacherMapper;

/**
 * @author 张娟娟
 * @date 2019/10/7 9:31 PM
 */
@Controller
public class TeacherController {

  @Autowired private TeacherMapper teacherMapper;
  @Autowired private TeacherCommentMapper teacherCommentMapper;

  @GetMapping(value = "/teacher")
  public String teacher(
      Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
    PageHelper.startPage(pageNum, 3);
    PageInfo<Teacher> pageInfo = new PageInfo(teacherMapper.selectAll());
    model.addAttribute("pageInfos", pageInfo);
    return "teacher";
  }

  @GetMapping(value = "/teacher/detail/{id}")
  public String teacherDetail(
      Model model,
      @PathVariable String id,
      @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
    PageHelper.startPage(pageNum, 3);
    PageInfo<TeacherComment> pageInfo = new PageInfo(teacherCommentMapper.findByTeacherId(id));
    model.addAttribute("pageInfos", pageInfo);
    model.addAttribute("teacher", teacherMapper.findById(Integer.parseInt(id)));
    return "teacher_detail";
  }

  @PostMapping(value = "/teacher/comment/")
  public String teacherComment(String teacherId, String username, String content) {
    String time = new Date().toString();
    teacherCommentMapper.insert(
        new TeacherComment(username, Integer.parseInt(teacherId), time, content));
    return "redirect:/teacher/detail/" + teacherId;
  }

  @GetMapping(value = "/teacher/new")
  public String courseNew() {
    return "teacher_form";
  }

  @PostMapping(value = "/teacher/new")
  public String newCourse(
      Model model, String name, String gender, String title, String introduction) {
    int res = teacherMapper.insert(new Teacher(name, gender, title, introduction));
    if (res <= 0) {
      model.addAttribute("teacherCreateError", true);
    }
    return "redirect:/teacher";
  }
}
