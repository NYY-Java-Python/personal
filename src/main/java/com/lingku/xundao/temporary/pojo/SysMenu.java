package com.lingku.xundao.temporary.pojo;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2019-03-11
 */
// @TableName("sys_menu")
public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 权限名称
	 */
	private String name;
	private String chineseName;
	/**
	 * 权限描述
	 */
	private String desc;
	/**
	 * 子菜单 所属 主菜单 ；， 菜单操作所属菜单
	 */
	private Integer parentId;

	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 菜单层级
	 */
	private Integer level;
	/**
	 * 最后一级菜单
	 */
	private Integer isLastLevel;
	/**
	 * 末级菜单对应页面路径
	 */
	private String urlPath;
	/**
	 * 菜单顺序
	 */
	private Integer order;
	private Date createTime;
	private Date updateTime;
	/**
	 * 状态：0：正常使用 1：删除
	 */
	private Integer status;

	private List<SysMethod> methodList;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getIsLastLevel() {
		return isLastLevel;
	}

	public void setIsLastLevel(Integer isLastLevel) {
		this.isLastLevel = isLastLevel;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<SysMethod> getMethodList() {
		return methodList;
	}

	public void setMethodList(List<SysMethod> methodList) {
		this.methodList = methodList;
	}

	@Override
	public String toString() {
		return "SysMenu{" + "id=" + id + ", name=" + name + ", chineseName=" + chineseName + ", desc=" + desc
				+ ", parentId=" + parentId + ", level=" + level + ", isLastLevel=" + isLastLevel + ", urlPath="
				+ urlPath + ", order=" + order + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", status=" + status + "}";
	}
}