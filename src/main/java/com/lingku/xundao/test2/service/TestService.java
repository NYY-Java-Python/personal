package com.lingku.xundao.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lingku.xundao.test2.mapper.TestMapper;
import com.lingku.xundao.user.pojo.UserInfo;

@Service
public class TestService {

	@Qualifier("TestMapper")
	private TestMapper testMapper;

	public UserInfo testSelect(String username) {

		return testMapper.testSelect(username);
	}

}
