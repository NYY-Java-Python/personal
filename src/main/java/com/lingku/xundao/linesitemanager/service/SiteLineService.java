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

	public List<PatSite> siteInfo() {

		return siteLineMapper.siteInfo();
	}

	public Integer updateSiteInfo(PatSite patSite) {
		
		return siteLineMapper.updateSiteInfo(patSite);
	}

	public Integer delSite(PatSite patSite) {
		
		return siteLineMapper.delSite(patSite);
	}

	public Integer delMulitSit(Integer[] ids) {
		
		return siteLineMapper.delMulitSit(ids);
	}

	public Integer addSiteInfo(PatSite patSite) {
		
		return siteLineMapper.addSiteInfo(patSite);
	}

	public List<LineInfo> lineInfo() {
		
		return siteLineMapper.lineInfo();
	}

	public Integer addLineInfo(LineInfo lineInfo) {
		
		return siteLineMapper.addLineInfo(lineInfo);
	}

}
