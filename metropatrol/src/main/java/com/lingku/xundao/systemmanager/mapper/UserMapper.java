package com.lingku.xundao.systemmanager.mapper;

import java.util.List;

import com.lingku.xundao.systemmanager.pojo.UserInfo;

public interface UserMapper {

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 获取基础用户信息
	 * @param userInfo
	 * @return
	 */
	List<UserInfo> userInfo(UserInfo userInfo);

	/**
	 * @author NYY
	 * @2019年6月6日
	 * @description 添加用户信息
	 * @param userInfo
	 * @return
	 */
	Integer addUser(UserInfo userInfo);

	/**
	 * @author NYY
	 * @2019年6月12日
	 * @description 更新用户信息
	 * @param userInfo
	 * @return
	 */
	Integer updateUserInfo(UserInfo userInfo);

	/**
	 * @author NYY
	 * @2019年6月12日
	 * @description 删除用户信息
	 * @param userId
	 * @return
	 */
	Integer deleteUserInfo(Integer userId);

	/**
	 * @author NYY
	 * @2019年6月12日
	 * @description 删除多个用户信息
	 * @param ids
	 * @return
	 */
	Integer delMulitUserInfo(Integer[] ids);

}
