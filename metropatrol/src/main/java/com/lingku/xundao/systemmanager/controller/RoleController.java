package com.lingku.xundao.systemmanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingku.xundao.systemmanager.pojo.RoleInfo;
import com.lingku.xundao.systemmanager.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author NYY
 * @2019年6月6日
 * @description 角色权限管理
 */
@RestController
@RequestMapping("role")
@Api(value = "RoleController", description = "系统管理-角色管理")
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 获取角色与权限相关
	 * @return
	 */
	@RequestMapping(value = "roleInfo", method = RequestMethod.POST)
	@ApiOperation(value = "获取基础角色信息与权限相关")
	public HashMap<String, Object> roleInfo(RoleInfo roleInfo) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			// 创建人
			roleInfo.setCreatePerson("创建人");

			roleInfo.setCreateTime(new Date());
			System.err.println("参数====>" + roleInfo);
			List<RoleInfo> Info = roleService.roleInfo();

			if (!Info.isEmpty()) {
				map.put("info", Info);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("RoleController:roleInfo====>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 添加角色信息-附带角色权限
	 * @param roleInfo
	 * @return
	 */

	@RequestMapping(value = "addRoel", method = RequestMethod.POST)
	@ApiOperation(value = "添加角色信息-附带角色权限")
	@ApiImplicitParams({ @ApiImplicitParam(name = "roleName", value = "角色名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "remark", value = "备注信息", required = false, dataType = "Stirng") })
	public HashMap<String, Object> addRoel(RoleInfo roleInfo) {

		roleInfo.setCreatePerson("admin");
		// 设置创建人id
		roleInfo.setCreateTime(new Date());
		// 设置创建时间

		HashMap<String, Object> map = new HashMap<>();
		try {
			// System.err.println("参数====>" + roleInfo);

			Integer addNum = roleService.addRoel(roleInfo);
			if (addNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("RoleController:addRoel====>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 更新角色-权限
	 * @param roleInfo
	 * @return
	 */
	@ApiOperation(value = "更新角色信息-附带角色权限")
	@RequestMapping(value = "udpateRoleInfo", method = RequestMethod.POST)
	@ApiImplicitParams({ 
			
		@ApiImplicitParam(name = "roleId", value = "角色id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "roleName", value = "角色名称", required = false, dataType = "String"),
			@ApiImplicitParam(name = "remark", value = "备注信息", required = false, dataType = "Stirng") })
	public HashMap<String, Object> udpateRoleInfo(RoleInfo roleInfo) {
		HashMap<String, Object> map = new HashMap<>();
		try {

			// System.err.println("参数====>" + roleInfo);
			Integer updateNum = roleService.udpateRoleInfo(roleInfo);
			if (updateNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no chage");
			}
			return map;
		} catch (Exception e) {
			System.err.println("RoleController:udpateRoleInfo====>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 删除角色与权限信息
	 * @return
	 */
	@RequestMapping(value = "delRoleInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除角色与权限信息-单个")
	@ApiImplicitParam(name = "roleId", value = "角色id", required = true, dataType = "Integer")
	public HashMap<String, Object> delRoleInfo(Integer roleId) {
		HashMap<String, Object> map = new HashMap<>();
		try {

			System.err.println("参数====>" + roleId);
			Integer delNum = roleService.delRoleInfo(roleId);
			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("RoleController:delRoleInfo====>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 批量删除角色信息
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delMulitRoleInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除角色与权限信息-批量")
	@ApiImplicitParam(name = "ids", value = "角色id", required = true, allowMultiple = true, dataType = "Integer")
	public HashMap<String, Object> delMulitRoleInfo(Integer[] ids) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			// System.err.println("参数====>"+ids);
			Integer delNum = roleService.delMulitRoleInfo(ids);

			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("RoleController:delRoleInfo====>" + e);
			map.put("message", "error");
			return map;
		}
	}

}
