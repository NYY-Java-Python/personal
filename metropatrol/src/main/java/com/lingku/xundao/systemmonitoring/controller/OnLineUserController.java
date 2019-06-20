package com.lingku.xundao.systemmonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingku.xundao.systemmonitoring.service.OnLineUserService;

import io.swagger.annotations.Api;

/**
 * @author NYY
 * @2019年6月17日
 * @description 1.系统监控-在线用户 2.系统日志
 */
@RequestMapping("onLine")
@Api(value = "OnLineUserController", description = "系统监控-在线用户")
public class OnLineUserController {

	@Autowired
	private OnLineUserService onLineUserService;

}
