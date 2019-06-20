package com.lingku.xundao.systemmanager.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月6日
 * @description 用户基础信息
 */
@TableName("sys_user")
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@TableId("userId")
	private Integer userId;
	// 主键id/用户id

	@TableId("username")
	private String username;
	// 用户名称(英)

	@TableId("name")
	private String name;
	// 中文;

	@TableId("password")
	private String password;
	// 密码

	@TableId("deptId")
	private Integer deptId;
	// 所属工班id

	@TableId("email")
	private String email;
	// 邮箱

	@TableId("mobile")
	private String mobile;
	// 手机号

	@TableId("status")
	private String status;
	// 状态0,正常1,禁用

	@TableId("CreteById")
	private Integer CreteById;
	// 创建人id

	@TableId("createTime")
	private Date createTime;
	// 创建时间

	@TableId("updateTime")
	private Date updateTime;
	// 更新时间

	@TableId("sex")
	private String sex;
	// 性别 0,男-1,女

	@TableId("birthday")
	private Date birthday;
	// 出生年月

	@TableId("address")
	private String address;
	// 居住地址

	@TableId("province")
	private String province;
	// 省

	@TableId("city")
	private String city;
	// 城

	@TableId("district")
	private String district;
	// 区域

	@TableId("roleId")
	private Integer roleId;

	// 角色id
	/**
	 * 
	 */
	public UserInfo() {
		super();

	}

	public UserInfo(Integer userId, String username, String name, String password, Integer deptId, String email,
			String mobile, String status, Integer creteById, Date createTime, Date updateTime, String sex,
			Date birthday, String address, String province, String city, String district, Integer roleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.password = password;
		this.deptId = deptId;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		CreteById = creteById;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.province = province;
		this.city = city;
		this.district = district;
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreteById() {
		return CreteById;
	}

	public void setCreteById(Integer creteById) {
		CreteById = creteById;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", deptId=" + deptId + ", email=" + email + ", mobile=" + mobile + ", status=" + status
				+ ", CreteById=" + CreteById + ", createTime=" + createTime + ", updateTime=" + updateTime + ", sex="
				+ sex + ", birthday=" + birthday + ", address=" + address + ", province=" + province + ", city=" + city
				+ ", district=" + district + ", roleId=" + roleId + "]";
	}

}
