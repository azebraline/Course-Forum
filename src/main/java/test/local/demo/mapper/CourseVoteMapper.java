package test.local.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import test.local.demo.entity.CourseVote;
import tk.mybatis.common.MyBaseMapper;

/**
 * @author 张娟娟
 * @date 2019/10/11 3:33 PM
 */
@Mapper
public interface CourseVoteMapper extends MyBaseMapper<CourseVote> {

  @Select("select * from course_vote where course_id = #{courseId} and username = #{username}")
  CourseVote voteCheck(int courseId, String username);
}
