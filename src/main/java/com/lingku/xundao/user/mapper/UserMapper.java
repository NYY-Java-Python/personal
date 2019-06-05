package com.lingku.xundao.user.mapper;

import com.lingku.xundao.user.pojo.UserInfo;

public interface UserMapper {

	UserInfo findUserById(String id);

	UserInfo findByUsername(String username);

	/**
	 * @author NYY
	 * @2019年5月31日
	 * @description 更新信息
	 * @param userInfo
	 * @return
	 */
	Integer updateUserInfo(UserInfo userInfo);

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 添加用户信息
	 * @param user
	 * @return
	 */
	void addUser(UserInfo user);

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 删除用户
	 * @param user
	 * @return
	 */
	Integer deleteUser(UserInfo user);

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 删除(多个)
	 * @param ids
	 * @return
	 */
	Integer deleteMoltiUser(Integer[] ids);

}
