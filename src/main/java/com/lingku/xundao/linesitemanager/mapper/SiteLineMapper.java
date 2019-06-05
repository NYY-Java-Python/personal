package com.lingku.xundao.linesitemanager.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lingku.xundao.linesitemanager.pojo.LineInfo;
import com.lingku.xundao.linesitemanager.pojo.PatSite;

public interface SiteLineMapper {

	/**
	 * @author NYY
	 * @2019年6月4日
	 * @description 获取所有站点信息
	 * @return
	 */
	List<PatSite> siteInfo();

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
	Integer delSite(PatSite patSite);

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
	List<LineInfo> lineInfo();

	/**
	 * @author NYY
	 * @2019年6月4日 
	 * @description 添加线路信息
	 * @param lineInfo
	 * @return
	 */
	Integer addLineInfo(LineInfo lineInfo);

}
