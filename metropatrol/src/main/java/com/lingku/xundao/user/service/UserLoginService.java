package com.lingku.xundao.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.user.mapper.UserLoginMapper;
import com.lingku.xundao.user.pojo.LoginUser;

@Service
public class UserLoginService {

	@Autowired
	private UserLoginMapper userMapper;

	public LoginUser findUserById(String userId) {

		return userMapper.findUserById(userId);
	}

	public LoginUser findByUsername(String username) {

		return userMapper.findByUsername(username);
	}

}
