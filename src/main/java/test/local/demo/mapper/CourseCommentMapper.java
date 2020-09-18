package test.local.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import test.local.demo.DTO.CourseCommentDTO;
import test.local.demo.entity.CourseComment;
import tk.mybatis.common.MyBaseMapper;

@Mapper
public interface CourseCommentMapper extends MyBaseMapper<CourseComment> {

  @Select("select * from course_comment where course_id = #{id}")
  List<CourseComment> findByCourseId(int id);

  @Select(
      "select courses.name as coursename, course_comment.username as username, course_comment.time as time, course_comment.content as content from course_comment, courses where course_comment.course_id = courses.id and course_comment.username = #{username}")
  ArrayList<CourseCommentDTO> findByUsername(String username);
}
