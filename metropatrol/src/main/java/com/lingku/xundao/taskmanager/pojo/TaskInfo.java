package com.lingku.xundao.taskmanager.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月3日
 * @description 任务信息实体
 */
@TableName("task_info")
public class TaskInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@TableId("tId")
	private Integer tId;
	// 主键id

	@TableId("taskTable")
	private String taskTable;
	// 任务表

	@TableId("deptName")
	private String deptName;
	// 班组名称

	@TableId("deptId")
	private Integer deptId;
	// 班组id

	@TableId("overstatus")
	private String overstatus;
	// 已经打卡站点

	@TableId("workId")
	private Integer workId;
	// 巡检人员id;

	@TableId("workName")
	private String workName;
	// 巡检人员姓名

	@TableId("patrolType")
	private String patrolType;
	// 巡线模式 (0.日常模式,1,节假日模式)

	@TableId("taskStatus")
	private String taskStatus;
	// 任务状态(待开始/新建0,进行中1,已完成2)

	@TableId("startTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	// 开始时间

	@TableId("endTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	// 结束时间

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

	@TableId("updteTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updteTime;
	// 更新时间

	@TableId("updatePerson")
	private String updatePerson;
	// 更新人

	@TableId("remark")
	private String remark;
	// 备注信息

	@TableId("isException")
	private String isException;
	// 是否异常
	/**
	 * 
	 */
	@TableId("lId")
	private Integer lId;
	// 任务表 //任务线路/表 id

	private List<TaskInfo> taskInfo;

	public TaskInfo() {
		super();

	}

	public TaskInfo(Integer tId, String taskTable, String deptName, Integer deptId, String overstatus, Integer workId,
			String workName, String patrolType, String taskStatus, Date startTime, Date endTime, String delFlag,
			Date createTime, String createPerson, Date updteTime, String updatePerson, String remark,
			String isException, Integer lId, List<TaskInfo> taskInfo) {
		super();
		this.tId = tId;
		this.taskTable = taskTable;
		this.deptName = deptName;
		this.deptId = deptId;
		this.overstatus = overstatus;
		this.workId = workId;
		this.workName = workName;
		this.patrolType = patrolType;
		this.taskStatus = taskStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.delFlag = delFlag;
		this.createTime = createTime;
		this.createPerson = createPerson;
		this.updteTime = updteTime;
		this.updatePerson = updatePerson;
		this.remark = remark;
		this.isException = isException;
		this.lId = lId;
		this.taskInfo = taskInfo;
	}

	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String getTaskTable() {
		return taskTable;
	}

	public void setTaskTable(String taskTable) {
		this.taskTable = taskTable;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getOverstatus() {
		return overstatus;
	}

	public void setOverstatus(String overstatus) {
		this.overstatus = overstatus;
	}

	public Integer getWorkId() {
		return workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getPatrolType() {
		return patrolType;
	}

	public void setPatrolType(String patrolType) {
		this.patrolType = patrolType;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public Date getUpdteTime() {
		return updteTime;
	}

	public void setUpdteTime(Date updteTime) {
		this.updteTime = updteTime;
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

	public String getIsException() {
		return isException;
	}

	public void setIsException(String isException) {
		this.isException = isException;
	}

	public Integer getlId() {
		return lId;
	}

	public void setlId(Integer lId) {
		this.lId = lId;
	}

	public List<TaskInfo> getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(List<TaskInfo> taskInfo) {
		this.taskInfo = taskInfo;
	}

	@Override
	public String toString() {
		return "TaskInfo [tId=" + tId + ", taskTable=" + taskTable + ", deptName=" + deptName + ", deptId=" + deptId
				+ ", overstatus=" + overstatus + ", workId=" + workId + ", workName=" + workName + ", patrolType="
				+ patrolType + ", taskStatus=" + taskStatus + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", delFlag=" + delFlag + ", createTime=" + createTime + ", createPerson=" + createPerson
				+ ", updteTime=" + updteTime + ", updatePerson=" + updatePerson + ", remark=" + remark
				+ ", isException=" + isException + ", lId=" + lId + ", taskInfo=" + taskInfo + "]";
	}

}
