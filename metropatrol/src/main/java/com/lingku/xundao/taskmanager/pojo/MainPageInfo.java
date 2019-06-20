package com.lingku.xundao.taskmanager.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月3日
 * @description 主页 展示信息
 */
public class MainPageInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private Integer all_new_task;
	// 新建任务量

	private Integer all_ongoing_task;
	// 正在进行中的任务

	private Integer all_finish_task;
	// 已完成的任务

	private Integer deptId;
	// 部门id//eg:线路一班..
	
	private String deptName;
	//部门名称

	private Integer dept_new_task;
	// 部门新建任务量

	private Integer dept_ongoing_task;
	// 部门正在进行中的任务

	private Integer dept_finish_task;
	// 部门已完成工作量

	public MainPageInfo() {
		super();

	}

	public MainPageInfo(Integer all_new_task, Integer all_ongoing_task, Integer all_finish_task, Integer deptId,
			String deptName, Integer dept_new_task, Integer dept_ongoing_task, Integer dept_finish_task) {
		super();
		this.all_new_task = all_new_task;
		this.all_ongoing_task = all_ongoing_task;
		this.all_finish_task = all_finish_task;
		this.deptId = deptId;
		this.deptName = deptName;
		this.dept_new_task = dept_new_task;
		this.dept_ongoing_task = dept_ongoing_task;
		this.dept_finish_task = dept_finish_task;
	}

	public Integer getAll_new_task() {
		return all_new_task;
	}

	public void setAll_new_task(Integer all_new_task) {
		this.all_new_task = all_new_task;
	}

	public Integer getAll_ongoing_task() {
		return all_ongoing_task;
	}

	public void setAll_ongoing_task(Integer all_ongoing_task) {
		this.all_ongoing_task = all_ongoing_task;
	}

	public Integer getAll_finish_task() {
		return all_finish_task;
	}

	public void setAll_finish_task(Integer all_finish_task) {
		this.all_finish_task = all_finish_task;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDept_new_task() {
		return dept_new_task;
	}

	public void setDept_new_task(Integer dept_new_task) {
		this.dept_new_task = dept_new_task;
	}

	public Integer getDept_ongoing_task() {
		return dept_ongoing_task;
	}

	public void setDept_ongoing_task(Integer dept_ongoing_task) {
		this.dept_ongoing_task = dept_ongoing_task;
	}

	public Integer getDept_finish_task() {
		return dept_finish_task;
	}

	public void setDept_finish_task(Integer dept_finish_task) {
		this.dept_finish_task = dept_finish_task;
	}

	@Override
	public String toString() {
		return "MainPageInfo [all_new_task=" + all_new_task + ", all_ongoing_task=" + all_ongoing_task
				+ ", all_finish_task=" + all_finish_task + ", deptId=" + deptId + ", deptName=" + deptName
				+ ", dept_new_task=" + dept_new_task + ", dept_ongoing_task=" + dept_ongoing_task
				+ ", dept_finish_task=" + dept_finish_task + "]";
	}



}
