package com.lingku.xundao.linesitemanager.mapper;

import java.util.List;

import com.lingku.xundao.linesitemanager.pojo.LineInfo;
import com.lingku.xundao.linesitemanager.pojo.PatSite;

import io.lettuce.core.dynamic.annotation.Param;

public interface SiteLineMapper {

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 获取所有站点信息
	 * @return
	 */
	List<PatSite> siteInfo( PatSite patSite);

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 更新站点信息
	 * @param patSite
	 * @return
	 */
	Integer updateSiteInfo(PatSite patSite);

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 删除站点信息
	 * @param patSite
	 * @return
	 */
	Integer delSite(Integer pId);

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 删除站点信息
	 * @param ids
	 * @return
	 */
	Integer delMulitSit(Integer[] ids);

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 增加站点信息
	 * @param patSite
	 * @return
	 */
	Integer addSiteInfo(PatSite patSite);

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 获取所有线路信息
	 * @return
	 */
	List<LineInfo> lineInfo(LineInfo lineInfo);

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 添加线路信息
	 * @param lineInfo
	 * @return
	 */
	Integer addLineInfo(LineInfo lineInfo);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 更新线路信息
	 * @param lineInfo
	 * @return
	 */
	Integer udpateLineInfo(LineInfo lineInfo);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除线路信息
	 * @param lineInfo
	 * @return
	 */
	Integer delLineInfo(Integer lId);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除线路信息(多个)
	 * @param ids
	 * @return
	 */
	Integer delMulitSiteinfo(Integer[] ids);

}
