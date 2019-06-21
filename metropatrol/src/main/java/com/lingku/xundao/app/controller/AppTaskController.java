package com.lingku.xundao.app.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingku.xundao.linesitemanager.pojo.LineInfo;
import com.lingku.xundao.linesitemanager.service.SiteLineService;
import com.lingku.xundao.systemmanager.pojo.UserInfo;
import com.lingku.xundao.systemmanager.pojo.WorkDept;
import com.lingku.xundao.systemmanager.service.UserService;
import com.lingku.xundao.systemmanager.service.WorkService;
import com.lingku.xundao.taskmanager.pojo.MainPageInfo;
import com.lingku.xundao.taskmanager.pojo.TaskInfo;
import com.lingku.xundao.taskmanager.service.TaskService;
import com.lingku.xundao.taskmanager.utils.TaskUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("app")
@Api(value = "AppTaskController", description = "App操作信息")
public class AppTaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private SiteLineService siteLineService;
	@Autowired
	private UserService userService;
	@Autowired
	private WorkService workService;

	/**
	 * @author NYY
	 * @2019年6月17日
	 * @description 历史统计
	 * @return
	 */
	@RequestMapping(value = "historyCount", method = RequestMethod.GET)
	@ApiOperation( value = "历史统计")
	public HashMap<String, Object> historyCount() {

		HashMap<String, Object> map = new HashMap<>();

		try {
			List<MainPageInfo> allInfo = taskService.mainPage();
			// 所有任务-新建-进行中-已完成 统计
			if (!allInfo.isEmpty()) {
				map.put("allInfo", allInfo);
			} else {
				map.put("allInfo", "no data");
			}
		} catch (Exception e) {
			System.out.println("AppTaskController:historyCount===>" + e);
			map.put("allInfo", "error");
		}

		try {
			List<MainPageInfo> taskInfo = taskService.deptCout();
			// 分工班任务量统计
			if (!taskInfo.isEmpty()) {
				map.put("taskInfo", taskInfo);
			} else {
				map.put("taskInfo", "no data");
			}
			return map;
		} catch (Exception e) {
			System.out.println("AppTaskController:historyCount===>" + e);
			map.put("taskInfo", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月17日
	 * @description 获取可分配的任务
	 * @return
	 */
	@RequestMapping(value = "getTaskInfo", method = RequestMethod.POST)
	@ApiOperation(value = "获取可分配的任务")
	public HashMap<String, Object> getTaskInfo() {
		HashMap<String, Object> map = new HashMap<>();

		/**
		 * 模拟数据
		 */
		TaskInfo task = new TaskInfo();

		task.setDeptId(1);
		task.setTaskTable("表2上行");
		// task.setTaskStatus("0");

		/**
		 * 
		 */

		try {
			// 1.Token 中获取登录用户信息
			// UserInfo info = new UserInfo();

			// TaskInfo task = new TaskInfo();
			// info.setDeptId(deptId);

			// task.setDeptId(deptId);
			// task.setPatrolType(patrolType);
			// task.setTaskTable(taskTable);

			System.err.println("参数====>" + task);
			List<TaskInfo> taskList = taskService.taskList(task);
			if (!taskList.isEmpty()) {
				map.put("taskList", taskList);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.out.println("AppTaskController:getTaskInfo==>" + e);
			map.put("message", "error");
			return map;
		}

		// 方法2.设置集合:在线路中设置该线路的请销站点信息
	}

	/**
	 * @author NYY
	 * @2019年6月18日
	 * @description 获取该任务线路的请销站点
	 * @param lineInfo
	 * @return
	 */
	@RequestMapping(value = "getSite", method = RequestMethod.POST)
	@ApiOperation( value = "获取任务线路请销站点")
	public HashMap<String, Object> getSite(LineInfo info) {

		// 1.任务线路id
		// 2.任务表名称
		/**
		 * 模拟数据
		 */
		info.setlId(4);

		/**
		 * 
		 */

		HashMap<String, Object> map = new HashMap<>();
		try {
			List<LineInfo> lineInfo = siteLineService.lineInfo(info);
			if (!lineInfo.isEmpty()) {
				map.put("lineInfo", lineInfo);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("AppTaskController:getSite===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月18日
	 * @description 获取登录用户的同工班用户信息-被分配的人员
	 * @return
	 */
	@RequestMapping(value = "getSameDeptUserInfo", method = RequestMethod.GET)
	@ApiOperation( value = "获取登录用户的同工班用户信息")
	public HashMap<String, Object> getSameDeptUserInfo() {
		HashMap<String, Object> map = new HashMap<>();
		try {
			// 1.Token 中获取登录用户信息
			// UserInfo info = new UserInfo();

			/**
			 * test
			 */

			UserInfo info = new UserInfo();
			info.setDeptId(1);
			info.setUserId(2);

			/**
			 *  
			 */

			List<UserInfo> userInfo = userService.userInfo(info);
			if (!userInfo.isEmpty()) {
				map.put("userInfo", userInfo);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.out.println("AppTaskController:getSameDeptUserInfo====>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月18日
	 * @description 获取任务记录
	 * @return
	 */
	@RequestMapping(value = "gerTaskRecord", method = RequestMethod.POST)
	@ApiOperation( value = "获取所有任务记录")
	public HashMap<String, Object> gerTaskRecord(TaskInfo taskInfo) {
		// 获取所有任务记录

		HashMap<String, Object> map = new HashMap<>();
		try {
			List<TaskInfo> taskRecord = taskService.taskList(taskInfo);
			if (!taskRecord.isEmpty()) {
				map.put("taskRecord", taskRecord);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("AppTaskController:gerTaskRecord====>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月18日
	 * @description 更新密码-获取用户信息
	 * @return
	 */
	@RequestMapping(value = "getUserInfo", method = RequestMethod.POST)
	@ApiOperation( value = "更新密码-获取用户信息")
	public HashMap<String, Object> getUserInfo() {
		HashMap<String, Object> map = new HashMap<>();

		// 1.token中获取用户基本信息
		UserInfo userInfo = new UserInfo();

		try {
			List<UserInfo> userList = userService.userInfo(userInfo);

			if (!userList.isEmpty()) {
				map.put("userList", userList);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("AppTaskController:getUserInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月18日
	 * @description 更新密码-更新密码
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value = "updatePassword", method = RequestMethod.POST)
	@ApiOperation( value = "更新密码-更新密码")
	public HashMap<String, Object> updatePassword(UserInfo userInfo) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			System.err.println("参数=====>" + userInfo);
			Integer updateNum = userService.updateUserInfo(userInfo);
			if (updateNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("messgae", "no change");
			}
			return map;
		} catch (Exception e) {
			System.out.println("AppTaskController:updatePassword===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月18日
	 * @description 登录用户所属工班信息
	 * @return
	 */
	@RequestMapping(value = "getDeptName", method = RequestMethod.POST)
	@ApiOperation(value = "登录用户所属工班信息")
	public HashMap<String, Object> getDeptName() {

		// Token中获取用户基本信息
		WorkDept dept = new WorkDept();
		dept.setDeptId(1);
		/**
		 * 
		 */
		HashMap<String, Object> map = new HashMap<>();
		try {
			List<WorkDept> workInfo = workService.workInfo(dept);
			if (!workInfo.isEmpty()) {
				map.put("workInfo", workInfo);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.out.println("AppTaskController:getDeptName" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月18日 
	 * @description 打卡,签到
	 * @param taskInfo
	 * @return
	 */
	@RequestMapping(value = "SignIn", method = RequestMethod.POST)
	@ApiOperation( value = "签到")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "tId", value = "任务id", required = true, dataType = "Integer"),
//		@ApiImplicitParam(name = "lId", value = "任务表 id", required = true, dataType = "Integer"),
//		@ApiImplicitParam(name = "taskTable", value = "任务表", required = true, dataType = "Stirng"),
//		@ApiImplicitParam(name = "deptName", value = "班组名称", required = true, dataType = "Stirng"),
//		@ApiImplicitParam(name = "deptId", value = "班组id", required = true, dataType = "Integer"),
//		@ApiImplicitParam(name = "patrolType", value = "巡线模式 0.日常模式-1,节假日模式", required = true, dataType = "Stirng"),
//		@ApiImplicitParam(name = "taskStatus", value = "任务状态(待开始/新建0,进行中1,已完成2)", required = true, dataType = "Stirng"),
//		@ApiImplicitParam(name = "startTime", value = "任务开始时间 yyyy-MM-dd HH:mm:ss", required = true, dataType = "Stirng") })
	public HashMap<String, Object> SignIn(TaskInfo taskInfo) {

		HashMap<String, Object> map = new HashMap<>();
		
//		taskInfo.settId(tId);//任务id
		///获取去
		List<TaskInfo> taskList = taskService.taskList(taskInfo);
		String mysql = taskList.get(0).getOverstatus();
		
		String concatWord = TaskUtil.concatWord(mysql, taskInfo.getOverstatus());
		
		try {
			
			//打卡站点
			//分配的巡道人员的id
			//任务状态
			taskInfo.setOverstatus(concatWord);//设置站点
			Integer updateNum = taskService.updateTaskInfo(taskInfo);

			if (updateNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("TaskController:SignInt" + e);
			map.put("message", "error");
			return map;
		}
	}

}
