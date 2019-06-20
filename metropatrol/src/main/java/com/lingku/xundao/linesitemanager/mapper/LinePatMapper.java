package com.lingku.xundao.linesitemanager.mapper;

import java.util.List;

import com.lingku.xundao.linesitemanager.pojo.PatLine;

public interface LinePatMapper {

	List<PatLine> baseLinePatInfo();

	Integer delLinePat(Integer lpId);

	Integer updateLinePatInfo(PatLine patLine);

	Integer addLinePatInfo(PatLine patLine);

}
