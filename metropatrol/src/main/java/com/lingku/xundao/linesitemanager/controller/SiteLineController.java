package com.lingku.xundao.linesitemanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lingku.xundao.linesitemanager.pojo.LineInfo;
import com.lingku.xundao.linesitemanager.pojo.PatSite;
import com.lingku.xundao.linesitemanager.service.SiteLineService;
import com.lingku.xundao.systemmanager.pojo.BasePage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author NYY
 * @2019年6月3日
 * @description 站点线路管理
 */
@RestController
@RequestMapping("site")
@Api(value = "SiteLineController", description = "站点管理相关操作")
public class SiteLineController {

	@Autowired
	private SiteLineService siteLineService;

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description 获取所有站点信息
	 * @return
	 */
	@RequestMapping(value = "siteInfo", method = RequestMethod.POST)
	@ApiOperation(value = "获取所有站点信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "currentPage", value = "当前页", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "currentPage", value = "当前页", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer")

	})

	public HashMap<String, Object> siteInfo(PatSite patSite, BasePage base) {

		HashMap<String, Object> map = new HashMap<>();

		// System.err.println("参数===>" +patSite );
		try {

			if (null == base || null == base.getCurrentPage() || null == base.getPageSize()) {
				PageHelper.startPage(1, 10);
			} else {
				PageHelper.startPage(base.getCurrentPage(), base.getPageSize());
			}

			List<PatSite> Info = siteLineService.siteInfo(patSite);

			if (!Info.isEmpty()) {
				PageInfo<PatSite> siteInfo = new PageInfo<PatSite>(Info);
				map.put("siteInfo", siteInfo);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:siteInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 增加站点信息
	 * @param patSite
	 * @return
	 */
	@RequestMapping(value = "addSiteInfo", method = RequestMethod.POST)
	@ApiOperation(value = "增加站点信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "siteName", value = "站点名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "magcardNum", value = "磁卡编号", required = true, dataType = "String"),
			@ApiImplicitParam(name = "siteStatus", value = "站点状态(0正常,1禁用)", required = true, dataType = "String"),
			@ApiImplicitParam(name = "remark", value = "备注信息", required = true, dataType = "String") })
	public HashMap<String, Object> addSiteInfo(PatSite patSite) {

		HashMap<String, Object> map = new HashMap<>();
		try {

			patSite.setCreateTime(new Date());
			//// 创建时间
			// patSite.setCreatePerson("测试人员");
			//// 创建人
			// System.err.println("参数===>" +patSite );

			Integer addNum = siteLineService.addSiteInfo(patSite);
			if (addNum > 0) {
				map.put("message", "succeed");
				return map;
			}
			map.put("message", "no channge");
			return map;

		} catch (Exception e) {
			System.err.println("SiteLineController:addSiteInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 更新站点信息
	 * @param patSite
	 * @return
	 */
	@RequestMapping(value = "updateSiteInfo", method = RequestMethod.POST)
	@ApiOperation(value = "更新站点信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "siteName", value = "站点名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "magcardNum", value = "磁卡编号", required = true, dataType = "String"),
			@ApiImplicitParam(name = "siteStatus", value = "站点状态(0正常,1禁用)", required = true, dataType = "String"),
			@ApiImplicitParam(name = "remark", value = "备注信息", required = true, dataType = "String"),
			@ApiImplicitParam(name = "pId", value = "站点id", required = true, dataType = "Integer") })
	public HashMap<String, Object> updateSiteInfo(PatSite patSite) {

		HashMap<String, Object> map = new HashMap<>();

		try {
			// patSite.setUpdatePerson("");
			// 更新人
			patSite.setUpdateTime(new Date());
			// 更新时间
			// System.err.println("参数===>" +patSite );
			if (patSite.getpId() != null) {
				Integer updateNum = siteLineService.updateSiteInfo(patSite);
				if (updateNum > 0) {
					map.put("message", "succeed");
					return map;
				}
			}

			map.put("message", " no change");
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:updateSiteInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 删除站点信息
	 * @param patSite
	 * @return
	 */
	@RequestMapping(value = "delSite", method = RequestMethod.POST)
	@ApiOperation(value = "删除站点信息")
	@ApiImplicitParam(name = "pId", value = "站点id", required = true, dataType = "Integer")
	public HashMap<String, Object> delSite(Integer pId) {
		HashMap<String, Object> map = new HashMap<>();
		try {

			// System.err.println("参数===>" +pId );
			Integer delNum = siteLineService.delSite(pId);
			if (delNum > 0) {
				map.put("message", "succeed");
				return map;
			}
			map.put("message", "no change");
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:delSite===>" + e);
			map.put("messge", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 删除多个站点信息
	 * @return
	 */
	@RequestMapping(value = "delMulitSit", method = RequestMethod.POST)
	@ApiOperation(value = "删除站点信息(多个)")
	@ApiImplicitParam(name = "ids", value = "站点id", required = true, allowMultiple = true, dataType = "Integer")
	public HashMap<String, Object> delMulitSit(Integer[] ids) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			System.err.println("参数===>" + ids);
			Integer delNum = siteLineService.delMulitSit(ids);
			if (delNum > 0) {
				map.put("message", "succeed");
				return map;
			}
			map.put("message", "no change");
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:delMulitSit===>" + e);
			map.put("message", "error");
			return map;

		}
	}

	// ==============================线路管理=================================
	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 获取所有线路信息
	 * @return
	 */
	@RequestMapping(value = "lineInfo", method = RequestMethod.POST)
	@ApiOperation(value = "获取所有线路信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "currentPage", value = "当前页", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = false, dataType = "Integer") })
	public HashMap<String, Object> lineInfo(LineInfo lineInfo, BasePage base) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			// System.err.println("参数===>" +lineInfo );
			if (null == base || null == base.getCurrentPage() || null == base.getPageSize()) {
				PageHelper.startPage(1, 10);
			} else {
				PageHelper.startPage(base.getCurrentPage(), base.getPageSize());
			}

			List<LineInfo> info = siteLineService.lineInfo(lineInfo);

			if (!info.isEmpty()) {
				PageInfo<LineInfo> lineInfos = new PageInfo<LineInfo>(info);
				map.put("lineInfos", lineInfos);
			} else {
				map.put("message", "no data");
			}
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:lineInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 添加线路信息
	 * @param lineInfo
	 * @return
	 */
	@RequestMapping(value = "addLineInfo", method = RequestMethod.POST)
	@ApiOperation(value = "添加线路信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "taskTable", value = "任务表名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "startSite", value = "请站点", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "endSite", value = "销站点", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "patrolType", value = "班组id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "patrolType", value = "巡线模式 (0.日常模式,1,节假日模式)", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "siteStatus", value = "线路状态(1正常,2禁用,默认1)", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "remark", value = "备注信息", required = true, dataType = "Stirng") })
	public HashMap<String, Object> addLineInfo(LineInfo lineInfo) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			lineInfo.setCreateTime(new Date());
			// 创建时间
			lineInfo.setCreatePerson("测试人员");
			// 创建人
			// System.err.println("参数===>" +lineInfo );
			Integer addNum = siteLineService.addLineInfo(lineInfo);
			if (addNum > 0) {
				map.put("message", "succeed");
				return map;
			}
			map.put("message", "no change");
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:lineInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 更新线路信息
	 * @param lineInfo
	 * @return
	 */

	@RequestMapping(value = "udpateLineInfo", method = RequestMethod.POST)
	@ApiOperation(value = "更新线路信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "taskTable", value = "任务表名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "startSite", value = "请站点", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "endSite", value = "销站点", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "patrolType", value = "班组id", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "patrolType", value = "巡线模式 (0.日常模式,1,节假日模式)", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "siteStatus", value = "线路状态(1正常,2禁用,默认1)", required = true, dataType = "Stirng"),
			@ApiImplicitParam(name = "remark", value = "备注信息", required = true, dataType = "Stirng") })
	public HashMap<String, Object> udpateLineInfo(LineInfo lineInfo) {

		HashMap<String, Object> map = new HashMap<>();
		Integer updateNum;
		try {
			lineInfo.setUpdateTime(new Date());
			// 更新时间
			lineInfo.setUpdatePerson("更新人员");
			// 更新人

			// System.err.println("参数===>" +lineInfo );
			if (lineInfo.getlId() != null) {
				updateNum = siteLineService.udpateLineInfo(lineInfo);
				if (updateNum > 0) {
					map.put("message", "succeed");
					return map;
				}
			}
			map.put("messge", "no change");
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:udpateLineInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除线路信息
	 * @param lineInfo
	 * @return
	 */
	@RequestMapping(value = "delLineInfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除线路信息-单个")
	@ApiImplicitParam(name = "lId", value = "线路id", required = true, dataType = "Integer")
	public HashMap<String, Object> delLineInfo(Integer lId) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			System.err.println("参数===>" + lId);
			Integer delNumber = siteLineService.delLineInfo(lId);
			if (delNumber > 0) {
				map.put("message", "succeed");
				return map;
			}
			map.put("message", "no change");
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:delLineInfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除线路信息多个
	 * @return
	 */
	@RequestMapping(value = "delMulitSiteinfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除线路信息(批量)")
	@ApiImplicitParam(name = "ids", value = "站点id", required = true, allowMultiple = true, dataType = "Integer")
	public HashMap<String, Object> delMulitSiteinfo(Integer[] ids) {

		HashMap<String, Object> map = new HashMap<>();
		try {
			// System.err.println("参数===>" +ids );
			Integer delNum = siteLineService.delMulitSiteinfo(ids);
			if (delNum > 0) {
				map.put("message", "succeed");
				return map;
			}
			map.put("message", "no change");
			return map;
		} catch (Exception e) {
			System.err.println("SiteLineController:delMulitSiteinfo===>" + e);
			map.put("message", "error");
			return map;
		}
	}
}
