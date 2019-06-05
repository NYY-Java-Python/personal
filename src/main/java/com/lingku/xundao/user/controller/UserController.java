package com.lingku.xundao.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingku.common.custom.RequiresLogin;
import com.lingku.common.protoken.TokenService;
import com.lingku.xundao.user.pojo.UserInfo;
import com.lingku.xundao.user.service.UserService;
import com.lk.common.model.ResponseDataModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("user")
@Api(value = "UserController", description = "用户相关操作")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;

	// 登录
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "用户登录")
	@ApiImplicitParams({ @ApiImplicitParam(name = "USERNAME", value = "用户名", dataType = "string", required = true),
			@ApiImplicitParam(name = "PASSWORD", value = "密码", dataType = "string", required = true) })
	public HashMap<String, Object> login(String USERNAME, String PASSWORD) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			UserInfo userForBase = userService.findByUsername(USERNAME);
			if (userForBase == null) {
				map.put("message", "登录失败,用户不存在");
				System.err.println("登录失败,用户不存在");
				return map;
			} else {
				if (!userForBase.getPassword().equals(PASSWORD)) {
					map.put("message", "登录失败,密码错误");
					System.err.println("登录失败,密码错误");
					return map;
				} else {

					String token = tokenService.getToken(userForBase);
					map.put("token", token);
					map.put("user", userForBase);
					return map;
				}
			}
		} catch (Exception e) {

			map.put("message", "查询数据异常");
			System.err.println("UserController" + e);
			return map;
		}
	}

	@RequestMapping(value = "getmessage", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "测试demo")
	@RequiresLogin
	public Map<String, Object> getMessage() {
		Map<String, Object> map = new HashMap<>();

		map.put("message:getMessage", "通过验证");

		return map;

		// return "你已通过验证";
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 更新用户信息
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	// @RequiresPremission("driver:update")
	@ApiOperation(response = ResponseDataModel.class, value = "更新用户资信息")
	@RequiresLogin
	public Map<String, Object> updateUserInfo(UserInfo userInfo) {
		
		
		Integer upd_num = userService.updateUserInfo(userInfo);
		
		Map<String, Object> map = new HashMap<>();

		map.put("message", "update通过验证");

		return map;
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 添加用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "addUser", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "添加用户")
	public HashMap<String, Object> addUser(UserInfo user) {

		
		userService.addUser(user);
		
		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 删除用户信息
	 * @param user
	 * @return
	 */
	@PostMapping("deleteUser")
	// @RequiresPremission("driver:add")
	@ApiOperation(response = ResponseDataModel.class, value = "删除用户信息(单个)")
	public HashMap<String, Object> deleteUser(UserInfo user) {
		Integer idNum = userService.deleteUser(user);
		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 删除多个用户信息
	 * @param ids
	 * @return
	 */
	@PostMapping("deleteMoltiUser")
	// @RequiresPremission("driver:add")
	@ApiOperation(response = ResponseDataModel.class, value = "删除多个用户信息")
	public HashMap<String, Object> deleteMoltiUser(Integer[] ids) {
		Integer num = userService.deleteMoltiUser(ids);
		return null;
	}

}
