package com.lingku.xundao.systemmanager.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月17日
 * @description 系统菜单管理
 */
@TableName("sys_menu")
public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("menuId")
	private Integer menuId;
	// 菜单id

	@TableId("parentId")
	private Integer parentId;
	// 父级菜单id

	@TableId("menuName")
	private String menuName;
	// 菜单名称

	@TableId("menuUrl")
	private String menuUrl;
	// 菜单地址

	@TableId("permission")
	private String permission;
	// 权限

	@TableId("type")
	private String type;
	// 类型 0：目录 1：菜单 2：按钮

	@TableId("icon")
	private String icon;
	// 菜单图标

	@TableId("orderNum")
	private Integer orderNum;
	// 排序

	@TableId("createTime")
	private Date createTime;
	// 创建时间

	@TableId("updateTime")
	private Date updateTime;
	// 修改时间

	/**
	 * 
	 */

	public SysMenu() {
		super();

	}

	public SysMenu(Integer menuId, Integer parentId, String menuName, String menuUrl, String permission, String type,
			String icon, Integer orderNum, Date createTime, Date updateTime) {
		super();
		this.menuId = menuId;
		this.parentId = parentId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.permission = permission;
		this.type = type;
		this.icon = icon;
		this.orderNum = orderNum;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
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

	@Override
	public String toString() {
		return "SysMenu [menuId=" + menuId + ", parentId=" + parentId + ", menuName=" + menuName + ", menuUrl="
				+ menuUrl + ", permission=" + permission + ", type=" + type + ", icon=" + icon + ", orderNum="
				+ orderNum + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
