package com.lingku.xundao.user.mapper;

import com.lingku.xundao.user.pojo.LoginUser;

public interface UserLoginMapper {

	LoginUser findUserById(String id);

	LoginUser findByUsername(String username);


}
