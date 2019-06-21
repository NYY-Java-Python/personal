package com.lingku.xundao.linesitemanager.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingku.xundao.linesitemanager.pojo.PatLine;
import com.lingku.xundao.linesitemanager.pojo.PatSite;
import com.lingku.xundao.linesitemanager.service.LinePatService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("linePat")
@Api(value = "LinePatController", description = "线路站点绑定管理相关操作")
public class LinePatController {
	/**
	 * 线路站点管理 绑定任务表(分日常模式和节假日模式)之间的所有的站点关系
	 */
	@Autowired
	private LinePatService linePatService;

	@RequestMapping(value = "baseLinePatInfo", method = RequestMethod.GET)
	@ApiOperation(value = "基础线路和站点的绑定信息")
	public HashMap<String, Object> baseLinePatInfo() {

		HashMap<String, Object> map = new HashMap<>();

		// 线路id
		// 线路名称
		// 站点id
		// 站点名称

		try {
			List<PatLine> patLines = linePatService.baseLinePatInfo();

			// System.err.println("patLines===>" + patLines);
			// 1 1 表1上行 5,13,12,11,10,9,8,7,6
			// 浔峰岗站上行,河沙站上行,沙贝站上行,横沙站上行,浔峰岗站前渡线,浔峰岗存车线,浔峰岗出段线,浔峰岗站后渡线2,浔峰岗站后渡线1

			// 1 1 表1上行 5,13,12,11,10,9,8,7,6
			// 浔峰岗站上行,河沙站上行,沙贝站上行,横沙站上行,浔峰岗站前渡线,浔峰岗存车线,浔峰岗出段线,浔峰岗站后渡线2,浔峰岗站后渡线1

			List<PatLine> patLineInfos = new ArrayList<>();

			for (PatLine patLine : patLines) {

				PatLine info = new PatLine();
				info.setLpId(patLine.getLpId());// id
				info.setlId(patLine.getlId());// 线路id
				info.setTaskTable(patLine.getTaskTable());// 任务表名

				String patIds = patLine.getPatIds();
				String patNames = patLine.getPatNames();

				// System.err.println("patIds===>" + patIds);
				// System.err.println("patNames===>" + patNames);

				if (!"".equals(patIds) && !"".equals(patNames)) {

					String[] PatpId = patIds.split(",");

					String[] PatSiteNames = patNames.split(",");

					List<Integer> ids = new ArrayList<>();

					for (String id : PatpId) {
						ids.add(Integer.parseInt(id));
					}
					List<String> names = new ArrayList<>();

					for (String name : PatSiteNames) {
						names.add(name);
					}

					List<PatSite> temp = new ArrayList<>();
					for (Integer id : ids) {
						PatSite site = new PatSite();
						site.setpId(id);
						temp.add(site);
					}
					for (int i = 0; i < temp.size(); i++) {
						for (int j = 0; i < names.size(); j++) {
							temp.get(i).setSiteName(names.get(i));
							// System.err.println(i);
							// System.out.println("patSite===>" + temp.get(i));
							break;
						}
					}
					info.setPatSite(temp);
				}
				patLineInfos.add(info);
			}
			map.put("patLineInfos", patLineInfos);
			return map;
		} catch (NumberFormatException e) {
			System.err.println("LinePatController:baseLinePatInfo====>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月20日
	 * @description 删除线路站点中的某个站点
	 * @param lpId
	 * @return
	 */
	@RequestMapping(value = "delLinePat", method = RequestMethod.POST)
	@ApiOperation(value = "删除线路的某个站点")
	@ApiImplicitParam(name = "lpId", value = "线路站点绑定id", required = true, dataType = "Integer")
	public HashMap<String, Object> delLinePat(Integer lpId) {

		HashMap<String, Object> map = new HashMap<>();

		try {
			System.err.println("参数===>" + lpId);
			Integer delNum = linePatService.delLinePat(lpId);

			if (delNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("LinePatController:delLinePat====>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月20日
	 * @description 更新线路的某个站点信息
	 * @param patLine
	 * @return
	 */

	@RequestMapping(value = "updateLinePatInfo", method = RequestMethod.POST)
	@ApiOperation(value = "更新线路的某个站点信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "lpId", value = "线路站点绑定id", required = true, dataType = "Integer"),
	})
	public HashMap<String, Object> updateLinePatInfo(PatLine patLine) {

		HashMap<String, Object> map = new HashMap<>();
		// 线路修改信息:
		//
		// 巡线模式
		// 线路名称(任务表名)-所有线路(任务表名称)
		// 站点名称-所有站点
		// 备注信息

		patLine.setUpdateTime(new Date());
		// 更新时间

		patLine.setUpdatePerson("更新人");
		// 更新人

		// 参数要求
		// 1. 线路站点绑定-主键id
		// 2.任务表
		// 3.线路id
		// 4.站点名称
		// 5.磁卡编号
		// 6.站点id
		// 7.备注
		// 8.巡道模式
		try {
			System.err.println("参数====>" + patLine);
			Integer updateNum = linePatService.updateLinePatInfo(patLine);
			if (updateNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("LinePatController:updateLinePatInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月20日
	 * @description 添加线路站点绑定关系
	 * @param patLine
	 * @return
	 */
	@RequestMapping(value = "addLinePatInfo", method = RequestMethod.POST)
	@ApiOperation(value = "添加线路站点绑定关系")
	@ApiImplicitParams({ @ApiImplicitParam(name = "lpId", value = "线路站点绑定id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "patrolType", value = "巡线模式(0,日常模式,1节假日模式)", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "lId", value = "任务表id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "taskTable", value = "任务表", required = true, dataType = "String"),
			@ApiImplicitParam(name = "siteName", value = "站点名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "magcardNum", value = "磁卡编号)", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "pId", value = "站点id", required = true, dataType = "Integer")
})
	public HashMap<String, Object> addLinePatInfo(PatLine patLine) {

		HashMap<String, Object> map = new HashMap<>();

		// 线路站点绑定-添加
		// 巡线模式
		// 全部线路名称
		// 全部站点名称
		// 备注信息

		patLine.setCreateTime(new Date());
		// 创建时间
		patLine.setCreatePerson("测试添加");

		try {
			System.err.println("参数====>" + patLine);
			Integer addNum = linePatService.addLinePatInfo(patLine);

			if (addNum > 0) {
				map.put("message", "succeed");
			} else {
				map.put("message", "no change");
			}
			return map;
		} catch (Exception e) {
			System.err.println("LinePatController:addLinePatInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

}
