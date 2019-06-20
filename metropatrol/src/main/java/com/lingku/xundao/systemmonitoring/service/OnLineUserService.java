package com.lingku.xundao.systemmonitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.systemmonitoring.mapper.OnLineUserMapper;

@Service
public class OnLineUserService {

	@Autowired
	private OnLineUserMapper onLineUserMapper;

}
