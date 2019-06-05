package com.lingku.xundao.linesitemanager.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月3日
 * @description 基础站点信息
 */

@TableName("paSite")
public class PatSite implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("")
	private Integer id;
	// 自增主键id

	private String siteName;
	// 站点名称

	private String magcardNum;
	// 磁卡编号

	private String siteStatus;
	// 站点状态(0正常,1禁用)

	private String delFlag;
	// 删除标志(0正常,1删除,默认0)

	private Date createTime;
	// 创建时间

	private String createPerson;
	// 创建人

	private Date udpateTime;
	// 更新时间

	private String updatePerson;
	// 更新人

	private String remark;
	// 备注信息

	public PatSite() {
		super();
		
	}

	public PatSite(Integer id, String siteName, String magcardNum, String siteStatus, String delFlag, Date createTime,
			String createPerson, Date udpateTime, String updatePerson, String remark) {
		super();
		this.id = id;
		this.siteName = siteName;
		this.magcardNum = magcardNum;
		this.siteStatus = siteStatus;
		this.delFlag = delFlag;
		this.createTime = createTime;
		this.createPerson = createPerson;
		this.udpateTime = udpateTime;
		this.updatePerson = updatePerson;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getUdpateTime() {
		return udpateTime;
	}

	public void setUdpateTime(Date udpateTime) {
		this.udpateTime = udpateTime;
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
		return "PatSite [id=" + id + ", siteName=" + siteName + ", magcardNum=" + magcardNum + ", siteStatus="
				+ siteStatus + ", delFlag=" + delFlag + ", createTime=" + createTime + ", createPerson=" + createPerson
				+ ", udpateTime=" + udpateTime + ", updatePerson=" + updatePerson + ", remark=" + remark + "]";
	}
	
	
}
