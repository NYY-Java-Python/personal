package com.lingku.xundao.test2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lingku.xundao.user.pojo.UserInfo;

//@Mapper
public interface TestMapper {

//	@Select("select * from admin_user where username = #{username}")
	UserInfo testSelect(String username);
}
