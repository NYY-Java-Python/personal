package com.lingku.xundao.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.taskmanager.mapper.TaskMapper;
import com.lingku.xundao.taskmanager.pojo.MainPageInfo;
import com.lingku.xundao.taskmanager.pojo.TaskInfo;

@Service
public class TaskService {

	@Autowired
	private TaskMapper taskMapper;

	public List<MainPageInfo> mainPage() {

		return taskMapper.mainPage();
	}

	public Integer addTask(TaskInfo taskInfo) {

		return taskMapper.addTask(taskInfo);
	}

	public List<TaskInfo> taskList(TaskInfo taskInfo) {

		return taskMapper.taskList(taskInfo);
	}

	public List<TaskInfo> taskRecord(TaskInfo taskInfo) {

		return taskMapper.taskRecord(taskInfo);
	}

	public Integer delTaskList(Integer tId) {

		return taskMapper.delTaskList(tId);
	}

	public Integer delMultiTasklist(Integer[] ids) {

		return taskMapper.delMultiTasklist(ids);
	}

	public Integer updateTaskInfo(TaskInfo taskInfo) {

		return taskMapper.updateTaskInfo(taskInfo);
	}

	public List<MainPageInfo> deptCout() {

		return taskMapper.deptCout();
	}

}
