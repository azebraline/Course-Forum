package test.local.demo.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import test.local.demo.entity.Activity;
import tk.mybatis.common.MyBaseMapper;

/**
 * @author hellohill
 * @date 2019/11/14 9:43 PM
 */
@Mapper
public interface ActivityMapper extends MyBaseMapper<Activity> {

  @Select("select * from activity order by id DESC")
  ArrayList<Activity> myselectAll();
}
