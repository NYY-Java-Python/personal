package com.lingku.xundao.taskmanager.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingku.xundao.taskmanager.pojo.MainPageInfo;
import com.lingku.xundao.taskmanager.pojo.TaskInfo;
import com.lingku.xundao.taskmanager.service.TaskService;
import com.lk.common.model.ResponseDataModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author NYY
 * @2019年6月3日
 * @description 任务管理-任务操作
 */

@RestController
@RequestMapping("task")
@Api(value = "TaskController", description = "任务管理相关操作")
public class TaskController {

	@Autowired
	private TaskService taskService;

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 主页任务信息展示
	 * @return
	 */
	@RequestMapping(value = "mainPage", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "主页展示信息")
	public HashMap<String, Object> mainPage() {
		// 新建任务量 ===>所有的
		// 进行中任务量===> 所有的
		// 已完成任务量===> 所有的

		List<MainPageInfo> info = taskService.mainPage();

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 新建任务信息
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "addTask", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "任务管理-新建")
	public HashMap<String, Object> addTask(TaskInfo taskInfo) {

		Integer num = taskService.addTask(taskInfo);

		return null;

	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 任务列表-所有任务信息
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "tasklist", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "任务管理-查看任务列表")
	public HashMap<String, Object> taskList(TaskInfo taskInfo) {

		List<TaskInfo> tasklist = taskService.taskList(taskInfo);

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月4日 
	 * @description 更新任务信息
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "updateTaskInfo", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "任务管理-编辑/更新任务信息")
	public HashMap<String , Object> updateTaskInfo(TaskInfo taskInfo){
		Integer changNum = taskService.updateTaskInfo(taskInfo);
		
		
		return null;
	}
	
	
	
	
	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 任务列表-删除任务信息(单个-逻辑删除)
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "delTaskList", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "任务管理-删除任务列表(单个)")
	public HashMap<String, Object> delTaskList(TaskInfo taskInfo) {

		Integer delNum = taskService.delTaskList(taskInfo);

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 任务列表-删除任务信息(多个-逻辑删除)
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "delMultiTasklist", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "任务管理-删除任务列表(多个个)")
	public HashMap<String, Object> delMultiTasklist(Integer[] ids) {

		Integer delNum = taskService.delMultiTasklist(ids);

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 查看任务记录
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "taskRecord", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "任务管理-查看任务记录")
	public HashMap<String, Object> taskRecord(TaskInfo taskInfo) {

		List<TaskInfo> taskRecore = taskService.taskRecord(taskInfo);
		return null;
	}

}
