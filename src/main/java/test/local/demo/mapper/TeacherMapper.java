package test.local.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import test.local.demo.entity.Teacher;
import tk.mybatis.common.MyBaseMapper;

/**
 * @author 张娟娟
 * @date 2019/10/9 10:20 AM
 */
@Mapper
public interface TeacherMapper extends MyBaseMapper<Teacher> {

  @Select("select * from teacher")
  List<Teacher> getAll();

  @Select("select * from teacher where id = #{id}")
  Teacher findById(int id);
}
