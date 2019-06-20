package com.lingku.xundao.temporary.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 末级菜单（即页面） 所拥有的操作。
 * </p>
 */
public class SysMenuAllMethod implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * method_id
	 */
	private Integer menuId;
	private Integer methodId;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMethodId() {
		return methodId;
	}

	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysMenuAllMethod{" + "id=" + id + ", menuId=" + menuId + ", methodId=" + methodId + ", createTime="
				+ createTime + "}";
	}
}
