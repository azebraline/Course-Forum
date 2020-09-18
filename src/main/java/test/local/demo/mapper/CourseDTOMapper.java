package test.local.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import test.local.demo.DTO.CourseDTO;
import test.local.demo.DTO.VoteDTO;
import tk.mybatis.common.MyBaseMapper;

@Mapper
public interface CourseDTOMapper extends MyBaseMapper<CourseDTO> {

  @Select(
      "select courses.id, courses.name, courses.vote, courses.dislike, courses.introduction, courses.teacher_id, teacher.name as teacher_name from courses, teacher where courses.teacher_id = teacher.id")
  List<CourseDTO> selectAll();

  @Select(
      "select courses.id, courses.name, courses.vote, courses.dislike, courses.introduction, courses.teacher_id, teacher.name as teacher_name from courses, teacher where courses.teacher_id = teacher.id order by vote desc limit 10")
  List<CourseDTO> selectRank();

  @Select(
      "select courses.id, courses.name, courses.vote, courses.dislike, courses.introduction, courses.teacher_id, teacher.name as teacher_name from courses, teacher where courses.teacher_id = teacher.id and courses.id = #{id}")
  CourseDTO findById(int id);

  @Select(
      "select courses.name as coursename, course_vote.username as username from courses, course_vote where courses.id=course_vote.course_id and course_vote.username=#{username}")
  ArrayList<VoteDTO> findVoteCourse(String username);
}
