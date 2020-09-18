package test.local.demo.service.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.local.demo.DTO.CourseCommentDTO;
import test.local.demo.DTO.TeacherCommentDTO;
import test.local.demo.DTO.VoteDTO;
import test.local.demo.entity.Authority;
import test.local.demo.entity.User;
import test.local.demo.mapper.AuthorityMapper;
import test.local.demo.mapper.CourseCommentMapper;
import test.local.demo.mapper.CourseDTOMapper;
import test.local.demo.mapper.TeacherCommentMapper;
import test.local.demo.mapper.UserMapper;
import test.local.demo.service.UserService;

/**
 * @author 张娟娟
 * @date 2019/9/29 11:20 AM
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

  @Autowired private UserMapper userMapper;
  @Autowired private AuthorityMapper authorityMapper;
  @Autowired private CourseCommentMapper courseCommentMapper;
  @Autowired private TeacherCommentMapper teacherCommentMapper;
  @Autowired private CourseDTOMapper courseDTOMapper;

  @Override
  public boolean reg(User user) {
    userMapper.insert(user);
    authorityMapper.insert(new Authority(user.getUsername(), "ROLE_USER"));
    return true;
  }

  public ArrayList<CourseCommentDTO> getCourseCommentByUser(String username) {
    return courseCommentMapper.findByUsername(username);
  }

  @Override
  public ArrayList<TeacherCommentDTO> getTeacherCommentByUser(String username) {
    return teacherCommentMapper.findByUsername(username);
  }

  @Override
  public ArrayList<VoteDTO> getVoteByUser(String username) {
    return courseDTOMapper.findVoteCourse(username);
  }
}
