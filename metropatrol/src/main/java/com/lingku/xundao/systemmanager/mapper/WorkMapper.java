package com.lingku.xundao.systemmanager.mapper;

import java.util.List;

import com.lingku.xundao.systemmanager.pojo.SubwayLineInfo;
import com.lingku.xundao.systemmanager.pojo.WorkDept;

import io.lettuce.core.dynamic.annotation.Param;

public interface WorkMapper {

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 获取工班信息
	 * @return
	 */

	List<WorkDept> workInfo(WorkDept workDept);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 添加工班信息
	 * @param workDeptInfo
	 * @return
	 */
	Integer addWrokInfo(WorkDept workDeptInfo);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 更新工班信息
	 * @param workDeptInfo
	 * @return
	 */
	Integer udpateWordInfo(WorkDept workDeptInfo);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除工班信息
	 * @param workDeptInfo
	 * @return
	 */
	Integer delWorkInfo(Integer id);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description
	 * @param ids
	 * @return
	 */
	Integer delMulitWorkDeptInfo(Integer[] ids);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 获取地铁线路信息
	 * @return
	 */
	List<SubwayLineInfo> getSubwayLineInfo(SubwayLineInfo subwayInfo);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 更新地铁线路信息
	 * @param subwayInfo
	 * @return
	 */
	Integer updateSubwayInfo(SubwayLineInfo subwayInfo);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 删除地铁线路信息
	 * @param id
	 * @return
	 */
	Integer delSubwayInfo(@Param(value = "subId") Integer subId);

	/**
	 * @author NYY
	 * @2019年6月5日
	 * @description 增加地铁线路信息
	 * @param sibwayLineInfo
	 * @return
	 */
	Integer addSubwayInfo(SubwayLineInfo sibwayLineInfo);

	/**
	 * @author NYY
	 * @2019年6月14日
	 * @description 删除多个地铁线路信息
	 * @param ids
	 * @return
	 */
	Integer delMulitSubwayInfo(Integer[] ids);

}
