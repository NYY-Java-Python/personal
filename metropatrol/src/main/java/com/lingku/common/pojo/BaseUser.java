package com.lingku.common.pojo;

import java.io.Serializable;

public class BaseUser implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long userId;
	// 用户名
	private String username;
	// 用户真实姓名
	private String name;
	// 密码
	private Integer userType;
	//用户类型
	private Integer roleId;
	//角色类型
	public BaseUser() {
		super();

	}
	public BaseUser(Long userId, String username, String name, Integer userType, Integer roleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.userType = userType;
		this.roleId = roleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	

}
