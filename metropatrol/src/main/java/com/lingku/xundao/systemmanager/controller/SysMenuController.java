//package com.lingku.xundao.systemmanager.controller;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lingku.xundao.systemmanager.pojo.SysMenu;
//import com.lingku.xundao.systemmanager.service.SysMenuService;
//import com.lk.common.model.ResponseDataModel;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//@RestController
//@RequestMapping("sys_menu")
//@Api(value = "SysMenuController", description = "系统管理-系统菜单管理")
//public class SysMenuController {
//
//	@Autowired
//	private SysMenuService sysMenuService;
//
//	/**
//	 * @author NYY
//	 * @2019年6月17日
//	 * @description 获取基础菜单信息
//	 * @return
//	 */
//	@RequestMapping(value = "baseInof", method = RequestMethod.GET)
//	@ApiOperation(response = ResponseDataModel.class, value = "获取基础菜单信息")
//	public HashMap<String, Object> baseInof() {
//		HashMap<String, Object> map = new HashMap<>();
//		try {
//			List<SysMenu> menuInfo = sysMenuService.baseInof();
//			if (!menuInfo.isEmpty()) {
//				map.put("menuInfo", menuInfo);
//			} else {
//				map.put("menuInfo", "no data");
//			}
//			return map;
//		} catch (Exception e) {
//			System.out.println("SysMenuController:baseInof===>" + e);
//			map.put("message", "error");
//			return map;
//		}
//	}
//
//	@RequestMapping(value = "addMenuInfo", method = RequestMethod.POST)
//	@ApiOperation(response = ResponseDataModel.class, value = "添加基础菜单信息")
//	public HashMap<String, Object> addMenuInfo(SysMenu menuInfo) {
//
//		HashMap<String, Object> map = new HashMap<>();
//		try {
//			System.out.println("参数:====>" + menuInfo);
//			Integer addNum = sysMenuService.addMenuInfo(menuInfo);
//			if (addNum > 0) {
//				map.put("message", "succeed");
//			} else {
//				map.put("message", "no change");
//			}
//			return map;
//		} catch (Exception e) {
//			System.out.println("SysMenuController:addMenuInfo===>" + e);
//			map.put("message", "error");
//			return map;
//		}
//	}
//
//	/**
//	 * @author NYY
//	 * @2019年6月17日
//	 * @description 更新菜单信息
//	 * @param menuInfo
//	 * @return
//	 */
//	@RequestMapping(value = "updateMenuInfo", method = RequestMethod.POST)
//	@ApiOperation(response = ResponseDataModel.class, value = "添加基础菜单信息")
//	public HashMap<String, Object> updateMenuInfo(SysMenu menuInfo) {
//
//		HashMap<String, Object> map = new HashMap<>();
//
//		try {
//			System.out.println("参数===>" + menuInfo);
//			Integer udpateNum = sysMenuService.updateMenuInfo(menuInfo);
//
//			if (udpateNum > 0) {
//				map.put("message", "succeed");
//			} else {
//				map.put("message", "no change");
//			}
//			return map;
//		} catch (Exception e) {
//			System.out.println("SysMenuController:updateMenuInfo===>" + e);
//			map.put("message", "error");
//			return map;
//
//		}
//	}
//
//	@RequestMapping(value = "deleteMenuInfo", method = RequestMethod.POST)
//	@ApiOperation(response = ResponseDataModel.class, value = "删除基础菜单信息")
//	public HashMap<String, Object> deleteMenuInfo(Integer menuId) {
//
//		HashMap<String, Object> map = new HashMap<>();
//
//		try {
//			System.out.println("参数===>" + menuId);
//			Integer delNum = sysMenuService.deleteMenuInfo(menuId);
//			if (delNum > 0) {
//				map.put("message", "succeed");
//			} else {
//				map.put("message", "no change");
//			}
//			return map;
//		} catch (Exception e) {
//			System.out.println("SysMenuController:deleteMenuInfo===>" + e);
//			map.put("message", "error");
//			return map;
//		}
//	}
//
//}
