package test.local.demo.service;

import java.util.ArrayList;
import test.local.demo.DTO.CourseCommentDTO;
import test.local.demo.DTO.TeacherCommentDTO;
import test.local.demo.DTO.VoteDTO;
import test.local.demo.entity.User;

public interface UserService {
  boolean reg(User user);

  ArrayList<CourseCommentDTO> getCourseCommentByUser(String username);

  ArrayList<TeacherCommentDTO> getTeacherCommentByUser(String username);

  ArrayList<VoteDTO> getVoteByUser(String username);
}
