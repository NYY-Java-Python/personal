package com.lingku.xundao.systemmanager.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月5日
 * @description 角色基础信息表
 */
@TableName("sys_role")
public class RoleInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("roleId")
	private Integer roleId;
	// 角色id

	@TableId("roleName")
	private String roleName;
	// 角色名/名称

	@TableId("roleSign")
	private String roleSign;
	// 英文

	@TableId("remark")
	private String remark;
	// 备注信息

	@TableId("createPerson")
	private String createPerson;
	// 创建人

	@TableId("createTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	// 创建时间

	public RoleInfo() {
		super();

	}

	public RoleInfo(Integer roleId, String roleName, String roleSign, String remark, String createPerson,
			Date createTime) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleSign = roleSign;
		this.remark = remark;
		this.createPerson = createPerson;
		this.createTime = createTime;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleSign() {
		return roleSign;
	}

	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "RoleInfo [roleId=" + roleId + ", roleName=" + roleName + ", roleSign=" + roleSign + ", remark=" + remark
				+ ", createPerson=" + createPerson + ", createTime=" + createTime + "]";
	}

}
