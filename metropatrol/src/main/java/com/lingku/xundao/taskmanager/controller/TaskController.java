package com.lingku.xundao.taskmanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.jsp.tagext.PageData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lingku.xundao.systemmanager.pojo.BasePage;
import com.lingku.xundao.taskmanager.pojo.MainPageInfo;
import com.lingku.xundao.taskmanager.pojo.TaskInfo;
import com.lingku.xundao.taskmanager.service.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

	private static final Logger TaskController = LoggerFactory.getLogger("TaskController");
	@Autowired
	private TaskService taskService;

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 主页任务信息展示
	 * @return
	 */
	@RequestMapping(value = "allCount", method = RequestMethod.GET)
	@ApiOperation(value = "主页-所有新建-进行中-已完成任务信息")
	public HashMap<String, Object> mainPage() {

		HashMap<String, Object> map = new HashMap<>();
		try {
			List<MainPageInfo> mainInfo = taskService.mainPage();

			if (!mainInfo.isEmpty()) {
				map.put("mainInfo", mainInfo);
			} else {
				map.put("message", "no data");
			}

			// Thread thread = new Thread() {
			// public void run() {
			// TaskController.info("用户*** 查询用户成功");
			// }
			// };
			// thread.start();
			// return JSONObject.toJSONString(testSelect,
			// SerializerFeature.WriteMapNullValue);
			return map;

		} catch (Exception e) {
			System.err.println("TaskController:mainPage+" + e);

			// Thread thread = new Thread() {
			// public void run() {
			// TaskController.info("用户***查用户失败");
			// }
			// };
			// thread.start();
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月10日
	 * @description 分工班-分状态统计
	 * @return
	 */
	@RequestMapping(value = "deptCout", method = RequestMethod.GET)
	@ApiOperation(value = "主页-所有工班中新建-进行中-已完成任务量")
	public HashMap<String, Object> deptCout() {

		HashMap<String, Object> map = new HashMap<>();
		try {
			List<MainPageInfo> mainInfo = taskService.deptCout();
			
			if (!mainInfo.isEmpty()) {
				map.put("mainInfo", mainInfo);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("TaskController:deptCout" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 新建任务信息
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "addTask", method = RequestMethod.POST)
	@ApiOperation(value = "任务管理-新建-待续改")
	public HashMap<String, Object> addTask(TaskInfo taskInfo) {
		// public HashMap<String, Object> addTask(HashMap<String, Object> info)
		// {

		HashMap<String, Object> map = new HashMap<>();
		try {
			System.err.println("参数===>" + taskInfo);

			Integer num = taskService.addTask(taskInfo);
			if (num > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no chang");
			}
			return map;
		} catch (Exception e) {

			System.err.println("TaskController:addTask===>" + e);
			map.put("message", "error");
			return map;
		}

		// HashMap<String, Object> map = new HashMap<>();
		// List<TaskInfo> task = null;
		//
		// try {
		// for (TaskInfo taskInfo : info) {
		// task = taskInfo.getTaskInfo();
		// }
		// System.err.println("参数=====>" + task);
		// } catch (Exception e) {
		// System.err.println("保存数据为空addTask" + e);
		// }
		//
		// try {
		// if (!task.isEmpty()) {
		// Integer addNum = 0;
		// for (TaskInfo taskInfo : task) {
		// Integer num = taskService.addTask(taskInfo);
		// if (num > 0) {
		// addNum++;
		// }
		// }
		// if (addNum > 0) {
		// map.put("mesage", "succeed");
		// return map;
		// }
		// map.put("mesage", "no change");
		// return map;
		// }
		// } catch (Exception e) {
		// System.err.println("TaskController:addTask==>" + e);
		// map.put("message", "error");
		// return map;
		// }
		// return map;

	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 任务列表-所有任务信息
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "tasklist", method = RequestMethod.POST)
	@ApiOperation(value = "任务管理-查看任务列表")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "currentPage", value = "当前页", required = false, dataType = "Integer"),
		@ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer") 
		})
	public HashMap<String, Object> taskList(TaskInfo taskInfo, BasePage base) {
		HashMap<String, Object> map = new HashMap<>();
		try {

			if (null == base || null == base.getCurrentPage() || null == base.getPageSize()) {
				PageHelper.startPage(1, 10);
			} else {
				PageHelper.startPage(base.getCurrentPage(), base.getPageSize());
			}
			System.err.println("参数=====>" + taskInfo);
			List<TaskInfo> taskList = taskService.taskList(taskInfo);

			if (!taskList.isEmpty()) {
				PageInfo<TaskInfo> taskListInfo = new PageInfo<TaskInfo>(taskList);
				map.put("taskListInfo", taskListInfo);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("TaskController:taskList===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 更新任务信息
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "updateTaskInfo", method = RequestMethod.POST)
	@ApiOperation(value = "任务管理-编辑/更新任务信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "tId", value = "任务id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "lId", value = "任务表 id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "taskTable", value = "任务表", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "deptName", value = "班组名称", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "deptId", value = "班组id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "patrolType", value = "巡线模式 0.日常模式-1,节假日模式", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "taskStatus", value = "任务状态(待开始/新建0,进行中1,已完成2)", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "startTime", value = "任务开始时间 yyyy-MM-dd HH:mm:ss", required = true, dataType = "Stirng") })
	public HashMap<String, Object> updateTaskInfo(TaskInfo taskInfo) {

		HashMap<String, Object> map = new HashMap<>();
		taskInfo.setUpdteTime(new Date());

		taskInfo.setUpdatePerson("测试更新");
		// 更新人

		taskInfo.setUpdteTime(new Date());
		// 更新时间

		try {
			System.err.println("参数=====>" + taskInfo);
			Integer udpateNum = taskService.updateTaskInfo(taskInfo);

			if (udpateNum > 0) {
				map.put("message", "succeed");
				return map;
			} else {
				map.put("message", "no change");
				return map;
			}
		} catch (Exception e) {
			System.err.println("TaskController:updateTaskInfo" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 任务列表-删除任务信息(单个-删除)
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "delTaskList", method = RequestMethod.POST)
	@ApiOperation(value = "任务管理-删除任务列表(单个)")
	@ApiImplicitParams({ @ApiImplicitParam(name = "tId", value = "任务id", required = true, dataType = "Integer") })
	public HashMap<String, Object> delTaskList(Integer tId) {
		// public HashMap<String, Object> delTaskList(TaskInfo taskInfo) {

		HashMap<String, Object> map = new HashMap<>();

		Integer delNum = 0;
		try {
			// System.err.println("参数=====>"+tId);
			delNum = taskService.delTaskList(tId);
			if (delNum != 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("TaskController:delTaskList===>" + e);
			map.put("message", "error");
			return map;
		}

	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 任务列表-删除任务信息(批量-删除)
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "delMultiTasklist", method = RequestMethod.POST)
	@ApiOperation(value = "任务管理-删除任务列表(批量)")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "tId", value = "任务id", required = true, allowMultiple = true, dataType = "Integer") })
	public HashMap<String, Object> delMultiTasklist(Integer[] ids) {
		HashMap<String, Object> map = new HashMap<>();

		Integer delNum = 0;
		try {
			System.err.println("参数===>" + ids);
			delNum = taskService.delMultiTasklist(ids);
			if (delNum != 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("TaskController:delMultiTasklist" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 查看任务记录
	 * @param taskInfo
	 * @return
	 */

	// @RequestMapping(value = "taskRecord", method = RequestMethod.POST)
	// @ApiOperation(response = ResponseDataModel.class, value = "任务管理-查看任务记录")
	// public HashMap<String, Object> taskRecord(TaskInfo taskInfo) {
	//
	// List<TaskInfo> taskRecore = taskService.taskRecord(taskInfo);
	// return null;
	// }



}
