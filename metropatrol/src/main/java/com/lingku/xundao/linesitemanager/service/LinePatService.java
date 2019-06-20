package com.lingku.xundao.linesitemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.linesitemanager.mapper.LinePatMapper;
import com.lingku.xundao.linesitemanager.pojo.PatLine;

@Service
public class LinePatService {

	@Autowired
	private LinePatMapper linePatMapper;

	public List<PatLine> baseLinePatInfo() {

		return linePatMapper.baseLinePatInfo();
	}

	public Integer delLinePat(Integer lpId) {
		
		return linePatMapper.delLinePat(lpId);
	}

	public Integer updateLinePatInfo(PatLine patLine) {
		
		return linePatMapper.updateLinePatInfo(patLine);
	}

	public Integer addLinePatInfo(PatLine patLine) {
		
		return linePatMapper.addLinePatInfo(patLine);
	}

}
