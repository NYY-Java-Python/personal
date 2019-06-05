package com.lingku.xundao.temporary.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 权限页面的操作方法。
 * </p>
 *
 * @author
 * @since 2019-03-11
 */
public class SysMethod implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	/**
	 * 操作英文标志
	 */
	private String name;
	/**
	 * 操作中文名称
	 */
	private String chineseName;
	private Date creatTime;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 状态：0：正常使用 1：删除
	 */
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SysMethod{" + "id=" + id + ", name=" + name + ", chineseName=" + chineseName + ", creatTime="
				+ creatTime + ", desc=" + desc + ", status=" + status + "}";
	}
}
