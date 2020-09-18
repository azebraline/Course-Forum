package test.local.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import test.local.demo.DTO.TeacherCommentDTO;
import test.local.demo.entity.TeacherComment;
import tk.mybatis.common.MyBaseMapper;

@Mapper
public interface TeacherCommentMapper extends MyBaseMapper<TeacherComment> {

  @Select("select * from teacher_comment where teacher_id = #{id}")
  List<TeacherComment> findByTeacherId(String id);

  @Select(
      "select teacher.name as teachername, teacher_comment.username as username, teacher_comment.time as time, teacher_comment.content as content from teacher_comment, teacher where teacher_comment.teacher_id = teacher.id and teacher_comment.username = #{username}")
  ArrayList<TeacherCommentDTO> findByUsername(String username);
}
