package com.lingku.xundao.systemmanager.mapper;

import java.util.List;

import com.lingku.xundao.systemmanager.pojo.RoleInfo;

public interface RoleMapper {

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 获取角色基础信息
	 * @return
	 */
	List<RoleInfo> roleInfo();

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 添加角色信息
	 * @param roleInfo
	 * @return
	 */
	Integer addRoel(RoleInfo roleInfo);

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 更新角色权限信息
	 * @param roleInfo
	 * @return
	 */
	Integer udpateRoleInfo(RoleInfo roleInfo);

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 删除角色权限信息
	 * @param roleId
	 * @return
	 */
	Integer delRoleInfo(Integer roleId);

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 删除角色信息
	 * @param ids
	 * @return
	 */
	Integer delMulitRoleInfo(Integer[] ids);
	
	

}
