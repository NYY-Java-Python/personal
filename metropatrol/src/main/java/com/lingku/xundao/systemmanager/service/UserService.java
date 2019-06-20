package com.lingku.xundao.systemmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.systemmanager.mapper.UserMapper;
import com.lingku.xundao.systemmanager.pojo.UserInfo;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<UserInfo> userInfo(UserInfo userInfo) {

		return userMapper.userInfo(userInfo);
	}

	public Integer addUser(UserInfo userInfo) {

		return userMapper.addUser(userInfo);
	}

	public Integer updateUserInfo(UserInfo userInfo) {
		
		return userMapper.updateUserInfo(userInfo);
	}

	public Integer deleteUserInfo(Integer userId) {
		
		return userMapper.deleteUserInfo(userId);
	}

	public Integer delMulitUserInfo(Integer[] ids) {
		
		return userMapper.delMulitUserInfo(ids);
	}

}
