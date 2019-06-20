package com.lingku.xundao.linesitemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.linesitemanager.mapper.SiteLineMapper;
import com.lingku.xundao.linesitemanager.pojo.LineInfo;
import com.lingku.xundao.linesitemanager.pojo.PatSite;

@Service
public class SiteLineService {

	@Autowired
	private SiteLineMapper siteLineMapper;

	public List<PatSite> siteInfo(PatSite patSite) {

		return siteLineMapper.siteInfo(patSite);
	}

	public Integer updateSiteInfo(PatSite patSite) {

		return siteLineMapper.updateSiteInfo(patSite);
	}

	public Integer delSite(Integer pId) {

		return siteLineMapper.delSite( pId);
	}

	public Integer delMulitSit(Integer[] ids) {

		return siteLineMapper.delMulitSit(ids);
	}

	public Integer addSiteInfo(PatSite patSite) {

		return siteLineMapper.addSiteInfo(patSite);
	}

	public List<LineInfo> lineInfo(LineInfo lineInfo) {

		return siteLineMapper.lineInfo( lineInfo);
	}

	public Integer addLineInfo(LineInfo lineInfo) {

		return siteLineMapper.addLineInfo(lineInfo);
	}

	public Integer udpateLineInfo(LineInfo lineInfo) {

		return siteLineMapper.udpateLineInfo(lineInfo);
	}

	public Integer delLineInfo(Integer lId) {

		return siteLineMapper.delLineInfo(lId);
	}

	public Integer delMulitSiteinfo(Integer[] ids) {

		return siteLineMapper.delMulitSiteinfo(ids);
	}

}
