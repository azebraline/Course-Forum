package test.local.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import test.local.demo.entity.Course;
import tk.mybatis.common.MyBaseMapper;

@Mapper
public interface CourseMapper extends MyBaseMapper<Course> {

  @Update("update courses set vote=vote+1 where id = #{courseId}")
  int updateLike(int courseId);
}
