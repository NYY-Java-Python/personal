package com.lingku.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lingku.xundao.systemmanager.pojo.UserInfo;

/**
 * @author NYY
 * @2019年6月21日
 * @description 工具类
 */
public class ToolUtils {

	/**
	 * @author NYY
	 * @2019年6月21日 
	 * @description 获取当前时间
	 * @return
	 */
	public static String getNowTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	
	/**
	 * @author NYY
	 * @2019年6月21日 
	 * @description 获取登录用户信息
	 * @return
	 */
	public static UserInfo getLoginUser(){
		
		//解析 获取登录用户信息
		
		UserInfo user = new UserInfo();
//		Session session = SecurityUtils.getSubject().getSession();
//		Object object = session.getAttribute("USERS");
//		BeanUtils.copyProperties(user, object);
		
		user.setUsername("admin");
		user.setName("测试日志");
		return user;
	}
	
}
