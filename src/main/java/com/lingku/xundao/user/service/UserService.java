package com.lingku.xundao.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.user.mapper.UserMapper;
import com.lingku.xundao.user.pojo.UserInfo;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public UserInfo findUserById(String userId) {

		return userMapper.findUserById(userId);
	}

	public UserInfo findByUsername(String username) {

		return userMapper.findByUsername(username);
	}

	public Integer updateUserInfo(UserInfo userInfo) {

		return userMapper.updateUserInfo(userInfo);
	}

	public void addUser(UserInfo user) {
		userMapper.addUser(user);
	}

	public Integer deleteUser(UserInfo user) {
		
		return userMapper.deleteUser(user);
	}

	public Integer deleteMoltiUser(Integer[] ids) {
		
		return userMapper.deleteMoltiUser(ids);
	}

}
