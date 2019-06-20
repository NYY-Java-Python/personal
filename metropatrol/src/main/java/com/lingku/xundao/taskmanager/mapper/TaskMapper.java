package com.lingku.xundao.taskmanager.mapper;

import java.util.List;

import com.lingku.xundao.taskmanager.pojo.MainPageInfo;
import com.lingku.xundao.taskmanager.pojo.TaskInfo;

public interface TaskMapper {

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 主页展示信息
	 * @return
	 */
	List<MainPageInfo> mainPage();

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 任务新建
	 * @param taskInfo
	 * @return
	 */
	Integer addTask(TaskInfo taskInfo);

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 查看任务列表
	 * @param taskInfo
	 * @return
	 */
	List<TaskInfo> taskList(TaskInfo taskInfo);

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 查看任务记录
	 * @param taskInfo
	 * @return
	 */
	List<TaskInfo> taskRecord(TaskInfo taskInfo);

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 删除任务信息单个
	 * @param taskInfo
	 * @return
	 */
	Integer delTaskList(Integer tId);

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 删除多个任务信息
	 * @param ids
	 * @return
	 */
	Integer delMultiTasklist(Integer[] ids);

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 更新任务信息
	 * @param taskInfo
	 * @return
	 */
	Integer updateTaskInfo(TaskInfo taskInfo);

	/**
	 * @author NYY
	 * @2019年6月10日
	 * @description 分工班-分状态统计
	 * @return
	 */
	List<MainPageInfo> deptCout();

}
