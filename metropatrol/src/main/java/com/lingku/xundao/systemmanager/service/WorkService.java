package com.lingku.xundao.systemmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.systemmanager.mapper.WorkMapper;
import com.lingku.xundao.systemmanager.pojo.SubwayLineInfo;
import com.lingku.xundao.systemmanager.pojo.WorkDept;

@Service
public class WorkService {
	@Autowired
	private WorkMapper workMapper;

	public List<WorkDept> workInfo(WorkDept workDept) {

		return workMapper.workInfo(workDept);
	}

	public Integer addWrokInfo(WorkDept workDeptInfo) {

		return workMapper.addWrokInfo(workDeptInfo);
	}

	public Integer udpateWordInfo(WorkDept workDeptInfo) {

		return workMapper.udpateWordInfo(workDeptInfo);
	}

	public Integer delWorkInfo(Integer id) {

		return workMapper.delWorkInfo(id);
	}

	public Integer delMulitWorkDeptInfo(Integer[] ids) {

		return workMapper.delMulitWorkDeptInfo(ids);
	}

	public List<SubwayLineInfo> getSubwayLineInfo(SubwayLineInfo subwayInfo) {

		return workMapper.getSubwayLineInfo(subwayInfo);
	}

	public Integer updateSubwayInfo(SubwayLineInfo subwayInfo) {

		return workMapper.updateSubwayInfo(subwayInfo);
	}

	public Integer delSubwayInfo(Integer subId) {

		return workMapper.delSubwayInfo(subId);
	}

	public Integer addSubwayInfo(SubwayLineInfo sibwayLineInfo) {

		return workMapper.addSubwayInfo(sibwayLineInfo);
	}

	public Integer delMulitSubwayInfo(Integer[] ids) {

		return workMapper.delMulitSubwayInfo(ids);
	}

}
