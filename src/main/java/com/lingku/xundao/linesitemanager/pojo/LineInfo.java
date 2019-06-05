package com.lingku.xundao.linesitemanager.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月4日
 * @description 线路管理
 */
@TableName("lineInfo")
public class LineInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("id")
	private Integer id;
	// 线路id

	private String taskTable;
	// 任务表

	private String startSite;
	// 请站点

	private String endSite;
	// 销站点

	private String patrolType;
	// 巡线模式(1,日常模式,2节假日模式)

	private String siteStatus;
	// 状态(1正常,2禁用,默认1)

	private String delFlag;
	// 删除标记(0,未删除,1.已删除,默认0.)

	private Date createTime;
	// 创建时间

	private String createPerson;
	// 创建人

	private Date updateTime;
	// 更新时间

	private String updatePerson;
	// 更新人

	private String remark;
	// 备注信息

	private String startCode;
	// 请站点磁卡编号

	private String endCode;
	// 销站点磁卡编号

	public LineInfo() {
		super();
		
	}

	public LineInfo(Integer id, String taskTable, String startSite, String endSite, String patrolType,
			String siteStatus, String delFlag, Date createTime, String createPerson, Date updateTime,
			String updatePerson, String remark, String startCode, String endCode) {
		super();
		this.id = id;
		this.taskTable = taskTable;
		this.startSite = startSite;
		this.endSite = endSite;
		this.patrolType = patrolType;
		this.siteStatus = siteStatus;
		this.delFlag = delFlag;
		this.createTime = createTime;
		this.createPerson = createPerson;
		this.updateTime = updateTime;
		this.updatePerson = updatePerson;
		this.remark = remark;
		this.startCode = startCode;
		this.endCode = endCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskTable() {
		return taskTable;
	}

	public void setTaskTable(String taskTable) {
		this.taskTable = taskTable;
	}

	public String getStartSite() {
		return startSite;
	}

	public void setStartSite(String startSite) {
		this.startSite = startSite;
	}

	public String getEndSite() {
		return endSite;
	}

	public void setEndSite(String endSite) {
		this.endSite = endSite;
	}

	public String getPatrolType() {
		return patrolType;
	}

	public void setPatrolType(String patrolType) {
		this.patrolType = patrolType;
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

	public String getStartCode() {
		return startCode;
	}

	public void setStartCode(String startCode) {
		this.startCode = startCode;
	}

	public String getEndCode() {
		return endCode;
	}

	public void setEndCode(String endCode) {
		this.endCode = endCode;
	}

	@Override
	public String toString() {
		return "LineManager [id=" + id + ", taskTable=" + taskTable + ", startSite=" + startSite + ", endSite="
				+ endSite + ", patrolType=" + patrolType + ", siteStatus=" + siteStatus + ", delFlag=" + delFlag
				+ ", createTime=" + createTime + ", createPerson=" + createPerson + ", updateTime=" + updateTime
				+ ", updatePerson=" + updatePerson + ", remark=" + remark + ", startCode=" + startCode + ", endCode="
				+ endCode + "]";
	}
	
	

}
