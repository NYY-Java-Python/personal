package com.lingku.xundao.systemmanager.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月5日
 * @description 工班信息
 */
@TableName("work_dept")
public class WorkDept implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("deptId")
	private Integer deptId;
	// 主键id/工班id

	@TableId("subId")
	private Integer subId;
	// 工班所属线路id

	@TableId("deptName")
	private String deptName;
	// 工班名称

	@TableId("orderNum")
	private Integer orderNum;
	// 排序

	@TableId("workStatus")
	private Integer workStatus;
	// 工班标记 0正常,1,禁用,默认0

	/**
	 * 
	 */
	@TableId("superiorId")
	private Integer superiorId;
	// 上级id
	@TableId("subwayName")
	private String subwayName;
	//地铁线路名称;

	/**
	 * 
	 */

	public WorkDept() {
		super();

	}

	public WorkDept(Integer deptId, Integer subId, String deptName, Integer orderNum, Integer workStatus,
			Integer superiorId, String subwayName) {
		super();
		this.deptId = deptId;
		this.subId = subId;
		this.deptName = deptName;
		this.orderNum = orderNum;
		this.workStatus = workStatus;
		this.superiorId = superiorId;
		this.subwayName = subwayName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(Integer workStatus) {
		this.workStatus = workStatus;
	}

	public Integer getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(Integer superiorId) {
		this.superiorId = superiorId;
	}

	public String getSubwayName() {
		return subwayName;
	}

	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}

	@Override
	public String toString() {
		return "WorkDept [deptId=" + deptId + ", subId=" + subId + ", deptName=" + deptName + ", orderNum=" + orderNum
				+ ", workStatus=" + workStatus + ", superiorId=" + superiorId + ", subwayName=" + subwayName + "]";
	}

}
