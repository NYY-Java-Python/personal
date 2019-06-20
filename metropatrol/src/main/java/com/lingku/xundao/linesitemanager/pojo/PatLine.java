package com.lingku.xundao.linesitemanager.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月18日
 * @description 线路站点绑定关系
 */
@TableName("pat_line")
public class PatLine implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("lpId")
	private Integer lpId;
	// 线路站点绑定-主键id

	@TableId("lId")
	private Integer lId;
	// 线路id

	@TableId("taskTable")
	private String taskTable;
	// 任务表

	@TableId("siteName")
	private String siteName;
	// 站点名称

	@TableId("magcardNum")
	private String magcardNum;
	// 磁卡编号

	@TableId("pId")
	private Integer pId;
	// 站点id

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableId("createTime")
	private Date createTime;
	// 创建时间

	@TableId("createPerson")
	private String createPerson;
	// 创建人

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableId("updateTime")
	private Date updateTime;
	// 更新时间

	@TableId("updatePerson")
	private String updatePerson;
	// 更新人

	@TableId("remark")
	private String remark;
	// 备注信息

	@TableId("patrolType")
	private String patrolType;
	// 巡线模式(0,日常模式,1节假日模式)

	/**
	 * 
	 */
	
	private String patIds;
	// 某个线路下所有站点id

	private String patNames;
	// 某个站点下所有站点的名称

	private List<PatSite> patSite;
	// 线路先所有站点集合

	public PatLine() {
		super();

	}

	public PatLine(Integer lpId, Integer lId, String taskTable, String siteName, String magcardNum, Integer pId,
			Date createTime, String createPerson, Date updateTime, String updatePerson, String remark,
			String patrolType, String patIds, String patNames, List<PatSite> patSite) {
		super();
		this.lpId = lpId;
		this.lId = lId;
		this.taskTable = taskTable;
		this.siteName = siteName;
		this.magcardNum = magcardNum;
		this.pId = pId;
		this.createTime = createTime;
		this.createPerson = createPerson;
		this.updateTime = updateTime;
		this.updatePerson = updatePerson;
		this.remark = remark;
		this.patrolType = patrolType;
		this.patIds = patIds;
		this.patNames = patNames;
		this.patSite = patSite;
	}

	public Integer getLpId() {
		return lpId;
	}

	public void setLpId(Integer lpId) {
		this.lpId = lpId;
	}

	public Integer getlId() {
		return lId;
	}

	public void setlId(Integer lId) {
		this.lId = lId;
	}

	public String getTaskTable() {
		return taskTable;
	}

	public void setTaskTable(String taskTable) {
		this.taskTable = taskTable;
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

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
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

	public String getPatrolType() {
		return patrolType;
	}

	public void setPatrolType(String patrolType) {
		this.patrolType = patrolType;
	}

	public String getPatIds() {
		return patIds;
	}

	public void setPatIds(String patIds) {
		this.patIds = patIds;
	}

	public String getPatNames() {
		return patNames;
	}

	public void setPatNames(String patNames) {
		this.patNames = patNames;
	}

	public List<PatSite> getPatSite() {
		return patSite;
	}

	public void setPatSite(List<PatSite> patSite) {
		this.patSite = patSite;
	}

	@Override
	public String toString() {
		return "PatLine [lpId=" + lpId + ", lId=" + lId + ", taskTable=" + taskTable + ", siteName=" + siteName
				+ ", magcardNum=" + magcardNum + ", pId=" + pId + ", createTime=" + createTime + ", createPerson="
				+ createPerson + ", updateTime=" + updateTime + ", updatePerson=" + updatePerson + ", remark=" + remark
				+ ", patrolType=" + patrolType + ", patIds=" + patIds + ", patNames=" + patNames + ", patSite="
				+ patSite + "]";
	}

}
