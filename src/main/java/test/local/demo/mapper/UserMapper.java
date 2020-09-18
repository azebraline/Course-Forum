package test.local.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import test.local.demo.entity.User;
import tk.mybatis.common.MyBaseMapper;

/**
 * @author 张娟娟
 * @date 2019/9/27 1:04 PM
 */
@Mapper
public interface UserMapper extends MyBaseMapper<User> {}
