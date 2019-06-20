package com.lingku.xundao.linesitemanager.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月3日
 * @description 基础站点信息
 */

@TableName("pat_site")
public class PatSite implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("pId")
	private Integer pId;
	// 自增主键pId
	
	@TableId("siteName")
	private String siteName;
	// 站点名称
	
	@TableId("magcardNum")
	private String magcardNum;
	// 磁卡编号
	
	@TableId("siteStatus")
	private String siteStatus;
	// 站点状态(0正常,1禁用)
	
	@TableId("delFlag")
	private String delFlag;
	// 删除标志(0正常,1删除,默认0)
	
	@TableId("createTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	// 创建时间
	
	@TableId("createPerson")
	private String createPerson;
	// 创建人
	
	@TableId("updateTime")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	// 更新时间
	
	@TableId("updatePerson")
	private String updatePerson;
	// 更新人
	
	@TableId("remark")
	private String remark;
	// 备注信息

	public PatSite() {
		super();

	}

	public PatSite(Integer pId, String siteName, String magcardNum, String siteStatus, String delFlag, Date createTime,
			String createPerson, Date updateTime, String updatePerson, String remark) {
		super();
		this.pId = pId;
		this.siteName = siteName;
		this.magcardNum = magcardNum;
		this.siteStatus = siteStatus;
		this.delFlag = delFlag;
		this.createTime = createTime;
		this.createPerson = createPerson;
		this.updateTime = updateTime;
		this.updatePerson = updatePerson;
		this.remark = remark;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getMagcardNum() {
		return magcardNum;
	}

	public void setMagcardNum(String magcardNum) {
		this.magcardNum = magcardNum;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "PatSite [pId=" + pId + ", siteName=" + siteName + ", magcardNum=" + magcardNum + ", siteStatus="
				+ siteStatus + ", delFlag=" + delFlag + ", createTime=" + createTime + ", createPerson=" + createPerson
				+ ", updateTime=" + updateTime + ", updatePerson=" + updatePerson + ", remark=" + remark + "]";
	}

}
