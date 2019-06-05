package com.lingku.common.passport;

import com.lingku.common.pojo.BaseUser;
import com.lingku.xundao.user.pojo.UserInfo;

/**
 * msxf.com Inc. Copyright (c) 2015-2017 All Rights Reserved.
 * 用来维护数据的本地线程变量,方便业务方直接从本地线程变量中获取用户相关信息的数据
 *
 */
public class PassportContext {

	private final static ThreadLocal<UserInfo> USER_LOCAL = new ThreadLocal();

	public static void setPassportUserInfo(UserInfo passportUserInfo) {

		USER_LOCAL.set(passportUserInfo);
		
	}

	public static UserInfo getPassportUserInfo() {
		return USER_LOCAL.get();
	}

	public static void clearData() {
		USER_LOCAL.remove();
	}

}
