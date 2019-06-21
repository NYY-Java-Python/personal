package com.lingku.xundao.systemmanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lingku.xundao.systemmanager.pojo.BasePage;
import com.lingku.xundao.systemmanager.pojo.UserInfo;
import com.lingku.xundao.systemmanager.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author NYY
 * @2019年6月6日
 * @description 系统管理-用户管理
 */
@Api(value = "UserController", description = "系统管理-用户管理")
@RestController
@RequestMapping("userManager")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 获取基础用户信息
	 * @return
	 */

	@RequestMapping(value = "userInfo", method = RequestMethod.POST)
	@ApiOperation(value = "获取用户基础信息")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "currentPage", value = "当前页", required = false, dataType = "Integer"),
		@ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer") })
	public HashMap<String, Object> userInfo(UserInfo userInfo, BasePage base) {

		HashMap<String, Object> map = new HashMap<>();
		System.err.println(" 参数====>" + userInfo);
		try {

			if (null == base || null == base.getCurrentPage() || null == base.getPageSize()) {
				PageHelper.startPage(1, 10);
			} else {
				PageHelper.startPage(base.getCurrentPage(), base.getPageSize());
			}

			List<UserInfo> userList = userService.userInfo(userInfo);
			if (!userList.isEmpty()) {
				PageInfo<UserInfo> userInfos = new PageInfo<UserInfo>(userList);
				map.put("userInfos", userInfos);
				return map;
			}
			map.put("message", "no data");
			return map;
		} catch (Exception e) {
			System.err.println("RoleController:userInfo====>" + e);
			map.put("messaage", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月10日
	 * @description 添加用户信息
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	@ApiOperation(value = "添加用户基础信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
			@ApiImplicitParam(name = "deptId", value = "所属工班", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String"),
			@ApiImplicitParam(name = "status", value = "用户状态(0,正常1,禁用)", required = true, dataType = "String"),
			@ApiImplicitParam(name = "roleId", value = "用户角色id", required = true, dataType = "Integer") })
	public HashMap<String, Object> addUser(UserInfo userInfo) {

		HashMap<String, Object> result = new HashMap<>();
		try {
			userInfo.setCreteById(5);
			// 创建人id

			userInfo.setCreateTime(new Date());
			// 创建时间

			// 设定角色id
			userInfo.setRoleId(6);
			userInfo.setDeptId(4);

			System.err.println("参数===>" + userInfo);
			Integer addNum = userService.addUser(userInfo);
			if (addNum > 0) {
				result.put("message", "succeed");
			} else {
				result.put("message", "no change");
			}
			return result;
		} catch (Exception e) {
			result.put("message", "error" + e);
			System.err.println("RoleController:addUser:用户信息添加失败===>" + e);
			return result;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月12日
	 * @description 更新用户信息
	 * @param userInfo
	 * @return
	 */

	@RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "更新用户基础信息")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String"),
			@ApiImplicitParam(name = "name", value = "姓名", required = false, dataType = "String"),
			@ApiImplicitParam(name = "username", value = "用户名", required = false, dataType = "Stirng"),
			@ApiImplicitParam(name = "password", value = "密码", required = false, dataType = "String"),
			@ApiImplicitParam(name = "deptId", value = "所属工班", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "email", value = "邮箱", required = false, dataType = "String"),
			@ApiImplicitParam(name = "status", value = "用户状态(0,正常1,禁用)", required = false, dataType = "String"),
			@ApiImplicitParam(name = "roleId", value = "用户角色id", required = false, dataType = "Integer") })
	public HashMap<String, Object> updateUserInfo(UserInfo userInfo) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			userInfo.setUpdateTime(new Date());
			// 更新时间

			Integer udpateNum = userService.updateUserInfo(userInfo);
			if (udpateNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("UserController:updateUserInfo" + e);
			// documentationPluginsBootstrapper
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月12日
	 * @description 删除用户信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "deleteUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除用户基础信息-单个")
	@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Integer")
	public HashMap<String, Object> deleteUserInfo(Integer userId) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			System.err.println("参数" + userId);
			Integer delNum = userService.deleteUserInfo(userId);
			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("UserController:deleteUserInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月12日
	 * @description 删除多个用户信息
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delMulitUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除多个用户基础信息-批量")
	@ApiImplicitParam(name = "ids", value = "角色id", required = true, allowMultiple = true, dataType = "Integer")
	public HashMap<String, Object> delMulitUserInfo(Integer[] ids) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			System.err.println("参数" + ids);
			Integer delNum = userService.delMulitUserInfo(ids);
			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("UserController:delMulitUserInfo" + e);
			map.put("message", "error");
			return map;
		}
	}

}
