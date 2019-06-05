package com.lingku.xundao.test2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lingku.xundao.test2.service.TestService;
import com.lingku.xundao.user.pojo.UserInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author NYY
 * @2019年5月27日
 * @description SWagger 方式测试交互
 */
@RestController
@RequestMapping("/test")
@Api(value = "/test", description = "测试SwaggerController")
public class SwaggerDemoController {

	private static final Logger SwaggerDemoController = LoggerFactory.getLogger("SwaggerDemoController");

	@Qualifier("TestService")
	private TestService testService;

	@ApiOperation(value = "测试根据用户名查询用户信息", notes = "备注")
	@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public String getTestUser(String username) {

		try {
			UserInfo testSelect = testService.testSelect(username);

			// Thread thread = new Thread() {
			// public void run() {
			// SwaggerDemoController.info("用户*** 查询用户成功");
			// }
			// };
			// thread.start();
			return JSONObject.toJSONString(testSelect, SerializerFeature.WriteMapNullValue);
		} catch (Exception e) {
			// Thread thread = new Thread() {
			// public void run() {
			// SwaggerDemoController.info("用户***查用户失败");
			// }
			// };
			// thread.start();
			System.err.println("controller:SwaggerDemoController" + e);
			return null;
		}

	}

}