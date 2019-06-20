//package com.lingku.xundao.systemmanager.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.lingku.xundao.systemmanager.mapper.SysMenuMapper;
//import com.lingku.xundao.systemmanager.pojo.SysMenu;
//
//@Service
//public class SysMenuService {
//
//	@Autowired
//	private SysMenuMapper sysMenuMapper;
//
//	public List<SysMenu> baseInof() {
//		return sysMenuMapper.baseInof();
//	}
//
//	public Integer addMenuInfo(SysMenu menuInfo) {
//
//		return sysMenuMapper.addMenuInfo(menuInfo);
//	}
//
//	public Integer updateMenuInfo(SysMenu menuInfo) {
//
//		return sysMenuMapper.updateMenuInfo(menuInfo);
//	}
//
//	public Integer deleteMenuInfo(Integer menuId) {
//		
//		return sysMenuMapper.deleteMenuInfo(menuId);
//	}
//
//}
