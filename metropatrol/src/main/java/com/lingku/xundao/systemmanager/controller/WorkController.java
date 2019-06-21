package com.lingku.xundao.systemmanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingku.common.utils.ToolUtils;
import com.lingku.xundao.systemmanager.pojo.SubwayLineInfo;
import com.lingku.xundao.systemmanager.pojo.WorkDept;
import com.lingku.xundao.systemmanager.service.WorkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author NYY
 * @2019年6月5日
 * @description 系统管理-工班管理
 */

@RestController
@RequestMapping("work")
@Api(value = "WorkController", description = "系统管理-工班管理")
public class WorkController {

	private static final Logger Work = LoggerFactory.getLogger("Work");

	@Autowired
	private WorkService workService;

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 获取工班基础信息
	 * @return
	 */
	@RequestMapping(value = "workInfo", method = RequestMethod.POST)
	@ApiOperation(value = "获取工班基础信息")
	public HashMap<String, Object> workInfo(WorkDept workDept) {

		HashMap<String, Object> map = new HashMap<>();

		try {
			System.err.println("参数===>" + workDept);
			List<WorkDept> workInfo = workService.workInfo(workDept);
			if (!workInfo.isEmpty()) {
				map.put("worakInfo", workInfo);
			} else {
				map.put("message", "no data");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",获取工班基础信息成功==>:" + workInfo);
				}
			};
			thread.start();

			return map;
		} catch (Exception e) {
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",获取工班基础信息失败==>:" + workDept);
				}
			};
			thread.start();

			System.err.println("WorkController:workInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 添加工班信息
	 * @param workDeptInfo
	 * @return
	 */
	@RequestMapping(value = "addWrokInfo", method = RequestMethod.POST)
	@ApiOperation(value = "添加工班信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "subId", value = "工班所属线路id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "deptName", value = "工班名称", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "workStatus", value = "工班标记 0正常,1,禁用,默认0", required = true, dataType = "Integer") })
	public HashMap<String, Object> addWrokInfo(WorkDept workDeptInfo) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			// System.err.println("参数====>"+workDeptInfo);
			Integer insertNum = workService.addWrokInfo(workDeptInfo);

			if (insertNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",添加工班基础信息成功==>:" + workDeptInfo);
				}
			};
			thread.start();

			return map;
		} catch (Exception e) {
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",添加工班基础信息失败==>:" + workDeptInfo);
				}
			};
			thread.start();

			System.err.println("WorkController:addWrokInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 更新工班信息
	 * @param workDeptInfo
	 * @return
	 */
	@RequestMapping(value = "udpateWordInfo", method = RequestMethod.POST)
	@ApiOperation(value = "更新工班信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "deptId", value = "工班id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "subId", value = "工班所属线路id", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "deptName", value = "工班名称", required = false, dataType = "Stirng"),
			@ApiImplicitParam(name = "workStatus", value = "工班标记 0正常,1,禁用,默认0", required = false, dataType = "Integer") })
	public HashMap<String, Object> udpateWordInfo(WorkDept workDeptInfo) {
		HashMap<String, Object> map = new HashMap<>();

		try {
			// System.err.println("参数====>"+workDeptInfo);
			Integer udpateNum = workService.udpateWordInfo(workDeptInfo);
			if (udpateNum > 0) {
				map.put("message", "secceed");
			} else {
				map.put("message", "no change");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",更新工班信息成功==>:" + workDeptInfo);
				}
			};
			thread.start();

			return map;
		} catch (Exception e) {

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",更新工班信息失败==>:" + workDeptInfo);
				}
			};
			thread.start();

			System.err.println("WorkController:udpateWordInfo" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除工班信息
	 * @param workDeptInfo
	 * @return
	 */
	@RequestMapping(value = "delWorkInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除工班信息")
	@ApiImplicitParam(name = "deptId", value = "工班id", required = true, dataType = "Integer")
	public HashMap<String, Object> delWorkInfo(Integer deptId) {
		HashMap<String, Object> map = new HashMap<>();

		try {
			// System.err.println("参数====>"+deptId);
			Integer delNum = workService.delWorkInfo(deptId);
			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ", 删除工班信息成功 工班唯一id==>:" + deptId);
				}
			};
			thread.start();
			return map;
		} catch (Exception e) {
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ", 删除工班信息失败:工班唯一id==>:" + deptId);
				}
			};
			thread.start();

			System.err.println("WorkController:delWorkInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除工班信息(批量)
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delMulitWorkDeptInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除工班信息-批量")
	@ApiImplicitParam(name = "ids", value = "工班id", required = true, allowMultiple = true, dataType = "Integer")
	public HashMap<String, Object> delMulitWorkDeptInfo(Integer[] ids) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			System.err.println("参数====>" + ids);
			Integer delNum = workService.delMulitWorkDeptInfo(ids);
			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",批量 删除工班信息成功 工班id==>:" + ids);
				}
			};
			thread.start();

			return map;
		} catch (Exception e) {
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",批量 删除工班信息失败 工班id==>:" + ids);
				}
			};
			thread.start();

			System.err.println("WorkController:delMulitWorkDeptInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	// ============================线路管理============================
	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description
	 * @return 获取地铁线路信息
	 */
	@RequestMapping(value = "getSubwayLineInfo", method = RequestMethod.POST)
	@ApiOperation(value = "获取地铁线路基础信息")
	public HashMap<String, Object> getSubwayLineInfo(SubwayLineInfo subwayInfo) {

		HashMap<String, Object> map = new HashMap<>();
		try {

			// System.err.println("参数====>" + subwayInfo);
			List<SubwayLineInfo> Info = workService.getSubwayLineInfo(subwayInfo);
			if (!Info.isEmpty()) {
				map.put("subwayInfo", Info);
			} else {
				map.put("message", "no data");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",获取地铁线路信息成功==>:" + Info);
				}
			};
			thread.start();
			return map;
		} catch (Exception e) {
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",获取地铁线路信息失败==>:" + subwayInfo);
				}
			};
			thread.start();
			System.err.println("WorkController:getSubwayLineInfo" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 增加地铁线路信息
	 * @param sibwayLineInfo
	 * @return
	 */
	@RequestMapping(value = "addSubwayInfo", method = RequestMethod.POST)
	@ApiOperation(value = "增加地铁线路信息")
	@ApiImplicitParam(name = "subwayName", value = "地铁线名称", required = true, dataType = "String")
	public HashMap<String, Object> addSubwayInfo(SubwayLineInfo sibwayLineInfo) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			// sibwayLineInfo.setCreatePerson("开发人员测试");
			// 创建人
			sibwayLineInfo.setCreateTime(new Date());
			// 创建时间
			System.err.println("参数====>" + sibwayLineInfo);
			Integer addNum = workService.addSubwayInfo(sibwayLineInfo);
			if (addNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",增加地铁线路信息成功==>:" + sibwayLineInfo);
				}
			};
			thread.start();
			return map;
		} catch (Exception e) {
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",增加地铁线路信息失败==>:" + sibwayLineInfo);
				}
			};
			thread.start();

			System.err.println("WorkController:addSubwayInfo====>" + e);
			map.put("jmessage", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 更新地铁线路信息
	 * @param subwayInfo
	 * @return
	 */
	@RequestMapping(value = "updateSubwayInfo", method = RequestMethod.POST)
	@ApiOperation(value = "更新地铁线路信息")
	@ApiImplicitParam(name = "subId", value = "地铁线路id", required = true, dataType = "Integer")
	public HashMap<String, Object> updateSubwayInfo(SubwayLineInfo subwayInfo) {

		HashMap<String, Object> map = new HashMap<>();
		try {

			subwayInfo.setUpdatePerson("更新人");
			// 设置更新人
			subwayInfo.setUpdateTime(new Date());
			// 更新时间
			System.err.println("参数====>" + subwayInfo);
			Integer updateNum = workService.updateSubwayInfo(subwayInfo);
			if (updateNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",更新地铁线路信息成功==>:" + subwayInfo);
				}
			};
			thread.start();
			return map;
		} catch (Exception e) {
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",更新地铁线路信息失败==>:" + subwayInfo);
				}
			};
			thread.start();
			System.err.println("WorkController:updateSubwayInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除地铁线路信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delSubwayInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除地铁线路信息-单个")
	@ApiImplicitParam(name = "subId", value = "地铁线id", required = true, dataType = "Integer")
	public HashMap<String, Object> delSubwayInfo(Integer subId) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			System.err.println("参数====>" + subId);
			Integer delNum = workService.delSubwayInfo(subId);
			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",删除地铁线路信息成功:唯一地铁id为==>:" + subId);
				}
			};
			thread.start();

			return map;
		} catch (Exception e) {
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",删除地铁线路信息失败:唯一地铁id为==>:" + subId);
				}
			};
			thread.start();
			System.err.println("WorkController:delSubwayInfo====>" + e);
			map.put("message", "errot");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月14日
	 * @description 删除多个地铁线路信息
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delMulitSubwayInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除地铁线路信息-批量")
	@ApiImplicitParam(name = "ids", value = "地铁id", required = true, allowMultiple = true, dataType = "Integer")
	public HashMap<String, Object> delMulitSubwayInfo(Integer[] ids) {

		HashMap<String, Object> map = new HashMap<>();
		// System.err.println("参数====>" + ids);
		try {
			Integer delNum = workService.delMulitSubwayInfo(ids);
			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no chanage");
			}

			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",批量删除地铁线路信息成功:地铁id为==>:" + ids);
				}
			};
			thread.start();
			return map;
		} catch (Exception e) {
			System.err.println("WorkController:delMulitSubwayInfo===>" + e);
			map.put("message", "error");
			Thread thread = new Thread() {
				public void run() {
					Work.info(ToolUtils.getNowTime() + "用户名:" + ToolUtils.getLoginUser().getUsername() + ",真实姓名:"
							+ ToolUtils.getLoginUser().getName() + ",批量删除地铁线路信息失败:地铁id为==>:" + ids);
				}
			};
			thread.start();
			return map;
		}
	}

}
