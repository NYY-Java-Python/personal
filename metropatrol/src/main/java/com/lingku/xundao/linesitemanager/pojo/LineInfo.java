package com.lingku.xundao.linesitemanager.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月4日
 * @description 线路管理/请站点-销站点
 */
@TableName("line_info")
public class LineInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("lId")
	private Integer lId;
	// 线路id
	
	@TableId("taskTable")
	private String taskTable;
	// 任务表
	
	@TableId("startSite")
	private String startSite;
	// 请站点
	
	@TableId("endSite")
	private String endSite;
	// 销站点
	
	@TableId("patrolType")
	private String patrolType;
	// 巡线模式 (0.日常模式,1,节假日模式)
	
	@TableId("siteStatus")
	private String siteStatus;
	// 线路状态(1正常,2禁用,默认1)
	
	@TableId("delFlag")
	private String delFlag;
	// 删除标记(0,未删除,1.已删除,默认0.)
	
	@TableId("createTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	// 创建时间
	
	@TableId("createPerson")
	private String createPerson;
	// 创建人
	
	@TableId("updateTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	// 更新时间
	
	@TableId("updatePerson")
	private String updatePerson;
	// 更新人
	
	@TableId("remark")
	private String remark;
	// 备注信息
	
	@TableId("startCode")
	private String startCode;
	// 请站点磁卡编号
	
	@TableId("endCode")
	private String endCode;
	// 销站点磁卡编号

	public LineInfo() {
		super();

	}

	public LineInfo(Integer lId, String taskTable, String startSite, String endSite, String patrolType,
			String siteStatus, String delFlag, Date createTime, String createPerson, Date updateTime,
			String updatePerson, String remark, String startCode, String endCode) {
		super();
		this.lId = lId;
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
		return "LineInfo [lId=" + lId + ", taskTable=" + taskTable + ", startSite=" + startSite + ", endSite=" + endSite
				+ ", patrolType=" + patrolType + ", siteStatus=" + siteStatus + ", delFlag=" + delFlag + ", createTime="
				+ createTime + ", createPerson=" + createPerson + ", updateTime=" + updateTime + ", updatePerson="
				+ updatePerson + ", remark=" + remark + ", startCode=" + startCode + ", endCode=" + endCode + "]";
	}

}
