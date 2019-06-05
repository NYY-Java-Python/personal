package com.lingku.xundao.linesitemanager.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingku.xundao.linesitemanager.pojo.LineInfo;
import com.lingku.xundao.linesitemanager.pojo.PatSite;
import com.lingku.xundao.linesitemanager.service.SiteLineService;
import com.lk.common.model.ResponseDataModel;

import io.swagger.annotations.Api;
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
	@RequestMapping(value = "siteInfo", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "获取所有站点信息")
	public HashMap<String, Object> siteInfo() {

		List<PatSite> siteInfo = siteLineService.siteInfo();

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 增加站点信息
	 * @param patSite
	 * @return
	 */

	@RequestMapping(value = "addSiteInfo", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "增加站点信息")
	public HashMap<String, Object> addSiteInfo(PatSite patSite) {

		Integer addNum = siteLineService.addSiteInfo(patSite);

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 更新站点信息
	 * @param patSite
	 * @return
	 */

	@RequestMapping(value = "updateSiteInfo", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "更新站点信息")
	public HashMap<String, Object> updateSiteInfo(PatSite patSite) {
		Integer updateNum = siteLineService.updateSiteInfo(patSite);

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 删除站点信息
	 * @param patSite
	 * @return
	 */

	@RequestMapping(value = "delSite", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "删除站点信息")
	public HashMap<String, Object> delSite(PatSite patSite) {

		Integer delNum = siteLineService.delSite(patSite);

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 删除多个站点信息
	 * @return
	 */
	@RequestMapping(value = "delMulitSit", method = RequestMethod.POST)
	@ApiOperation(response = ResponseDataModel.class, value = "删除站点信息(多个)")
	public HashMap<String, Object> delMulitSit(Integer[] ids) {
		Integer delNum = siteLineService.delMulitSit(ids);
		return null;
	}

	// ==============================线路管理=================================

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 获取所有线路信息
	 * @return
	 */
	@RequestMapping(value = "lineInfo", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "获取所有线路信息")
	public HashMap<String, Object> lineInfo() {

		List<LineInfo> lineInfo = siteLineService.lineInfo();

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 添加线路信息
	 * @param lineInfo
	 * @return
	 */
	@RequestMapping(value = "addLineInfo", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "添加线路信息")
	public HashMap<String, Object> addLineInfo(LineInfo lineInfo) {

		Integer addNum = siteLineService.addLineInfo(lineInfo);

		return null;
	}

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 更新线路信息
	 * @param lineInfo
	 * @return
	 */
	@RequestMapping(value = "udpateLineInfo", method = RequestMethod.GET)
	@ApiOperation(response = ResponseDataModel.class, value = "更新线路信息")
	public HashMap<String, Object> udpateLineInfo(LineInfo lineInfo) {

		return null;

	}

}
