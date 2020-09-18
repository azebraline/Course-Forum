package test.local.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import test.local.demo.entity.Authority;
import tk.mybatis.common.MyBaseMapper;

@Mapper
public interface AuthorityMapper extends MyBaseMapper<Authority> {}
