package com.lingku.xundao.user.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年5月23日
 * @description
 */
@TableName("sys_user")
public class UserInfo {

	@TableId(value = "user_id")
	private Integer user_id;

	@TableId(value = "username")
	private String username;

	@TableId(value = "password")
	private String password;

	@TableId("role_id")
	private Integer role_id;

	@TableId("user_type")
	private Integer user_type;

	public UserInfo() {
		super();
		
	}

	public UserInfo(Integer user_id, String username, String password, Integer role_id, Integer user_type) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.role_id = role_id;
		this.user_type = user_type;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getUser_type() {
		return user_type;
	}

	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "TestUser [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role_id="
				+ role_id + ", user_type=" + user_type + "]";
	}

	
}
