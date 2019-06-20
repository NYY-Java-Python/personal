package com.lingku.xundao.systemmanager.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月5日
 * @description 地铁线路
 */
@TableName("subway_line")
public class SubwayLineInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("subId")
	private Integer subId;
	// 地铁下路id

	@TableId("subwayName")
	private String subwayName;
	// 地铁线路名称

	private List<WorkDept> workDept;
	// 该地铁线路下的所有工班

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

	public SubwayLineInfo() {
		super();

	}

	public SubwayLineInfo(Integer subId, String subwayName, List<WorkDept> workDept, Date createTime,
			String createPerson, Date updateTime, String updatePerson, String remark) {
		super();
		this.subId = subId;
		this.subwayName = subwayName;
		this.workDept = workDept;
		this.createTime = createTime;
		this.createPerson = createPerson;
		this.updateTime = updateTime;
		this.updatePerson = updatePerson;
		this.remark = remark;
	}

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getSubwayName() {
		return subwayName;
	}

	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}

	public List<WorkDept> getWorkDept() {
		return workDept;
	}

	public void setWorkDept(List<WorkDept> workDept) {
		this.workDept = workDept;
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
		return "SubwayLineInfo [subId=" + subId + ", subwayName=" + subwayName + ", workDept=" + workDept
				+ ", createTime=" + createTime + ", createPerson=" + createPerson + ", updateTime=" + updateTime
				+ ", updatePerson=" + updatePerson + ", remark=" + remark + "]";
	}

}
