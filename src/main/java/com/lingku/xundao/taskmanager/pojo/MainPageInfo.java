package com.lingku.xundao.taskmanager.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author NYY
 * @2019年6月3日
 * @description 主页 展示信息
 */
@TableName("tablename")
public class MainPageInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@TableId("")
	private Integer all_new_task;
	// 新建任务量

	@TableId("")
	private Integer all_ongoing_task;
	// 正在进行中的任务

	@TableId("")
	private Integer all_finish_task;
	// 已完成的任务

	@TableId("")
	private Integer dept_id;
	// 部门id//eg:线路一班..

	@TableId("")
	private Integer new_task;
	// 部门新建任务量

	@TableId("")
	private Integer ongoing_task;
	// 部门正在进行中的任务

	@TableId("")
	private Integer finish_task;
	// 部门已完成工作量

	public MainPageInfo() {
		super();

	}

	public MainPageInfo(Integer all_new_task, Integer all_ongoing_task, Integer all_finish_task, Integer dept_id,
			Integer new_task, Integer ongoing_task, Integer finish_task) {
		super();
		this.all_new_task = all_new_task;
		this.all_ongoing_task = all_ongoing_task;
		this.all_finish_task = all_finish_task;
		this.dept_id = dept_id;
		this.new_task = new_task;
		this.ongoing_task = ongoing_task;
		this.finish_task = finish_task;
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

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public Integer getNew_task() {
		return new_task;
	}

	public void setNew_task(Integer new_task) {
		this.new_task = new_task;
	}

	public Integer getOngoing_task() {
		return ongoing_task;
	}

	public void setOngoing_task(Integer ongoing_task) {
		this.ongoing_task = ongoing_task;
	}

	public Integer getFinish_task() {
		return finish_task;
	}

	public void setFinish_task(Integer finish_task) {
		this.finish_task = finish_task;
	}

	@Override
	public String toString() {
		return "MainPageInfo [all_new_task=" + all_new_task + ", all_ongoing_task=" + all_ongoing_task
				+ ", all_finish_task=" + all_finish_task + ", dept_id=" + dept_id + ", new_task=" + new_task
				+ ", ongoing_task=" + ongoing_task + ", finish_task=" + finish_task + "]";
	}

}
