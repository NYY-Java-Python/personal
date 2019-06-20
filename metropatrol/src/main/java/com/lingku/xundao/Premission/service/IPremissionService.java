package com.lingku.xundao.Premission.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.lingku.common.passport.Constants;
import com.lingku.xundao.temporary.mapper.SysMenuAllMethodMapper;
import com.lingku.xundao.temporary.mapper.SysMenuMapper;
import com.lingku.xundao.temporary.mapper.SysRolePremissionMapper;
import com.lingku.xundao.temporary.pojo.RoleMenuVo;
import com.lingku.xundao.temporary.pojo.RoleMethodVo;
import com.lingku.xundao.temporary.pojo.SysMenu;
import com.lingku.xundao.temporary.pojo.SysMenuAllMethod;
import com.lingku.xundao.temporary.pojo.SysMethod;
import com.lingku.xundao.temporary.pojo.SysMethodMapper;
import com.lingku.xundao.temporary.pojo.SysRolePremission;
import com.lk.common.utils.CachedBeanCopier;

@Service
public class IPremissionService implements InitializingBean {

	private Cache<Integer, Set<String>> localCache;

	@Qualifier("SysMethodMapper")
	private SysMethodMapper methodMapper;

	@Qualifier("SysMenuMapper")
	private SysMenuMapper menuMapper;

	@Qualifier("SysMenuAllMethodMapper")
	private SysMenuAllMethodMapper sysMenuAllMethodMapper;

	@Qualifier("SysRolePremissionMapper")
	private SysRolePremissionMapper rolePremissionMapper;

	private Map<Integer, SysMethod> allIdToMethod;

	public Set<String> getPremissionName(Integer roleId, String token) {
		Set<String> premissionSet = localCache.getIfPresent(token);
		if (premissionSet != null) {
			return premissionSet;
		}

		Wrapper<SysRolePremission> rolePremissionWrapper = new EntityWrapper<SysRolePremission>().eq("role_id", roleId);
		List<SysRolePremission> rolePremissionList = rolePremissionMapper.selectList(rolePremissionWrapper);

		if (rolePremissionList.size() == 0) {
			return null;
		}

		// 所有二级菜单。
		Map<Integer, SysMenu> idToMenu = getIdToMenu();
		Map<Integer, SysMethod> idToMethod = getIdToMethod();

		// 角色有的菜单
		Set<String> needPremission = new HashSet<>();
		for (SysRolePremission rolePremission : rolePremissionList) {
			Integer menuId = rolePremission.getMenuId();
			SysMenu menu = idToMenu.get(menuId);
			// 不属于二级菜单
			if (menu == null) {
				continue;
			}

			if (!needPremission.contains(menu.getName())) {
				needPremission.add(menu.getName());
			}

			Integer methodId = rolePremission.getMethodId();
			if (methodId != null && idToMethod.containsKey(methodId)) {
				needPremission.add(menu.getName() + Constants.MENUANDMETHOD + idToMethod.get(methodId).getName());
			}
		}

		localCache.put(roleId, needPremission);

		return needPremission;
	}

	// 获取所有所有权限
	public List<RoleMenuVo> getAllPremission() {
		// 查询得到所有菜单列表
		List<SysMenu> allMenus = menuMapper.selectList(new EntityWrapper<>());

		Map<Integer, List<SysMenu>> pidToMenuList = getPidToMenuList(allMenus);

		return getAllRoleMenuVo(allMenus, pidToMenuList);
	}

	/**
	 * 根据用户角色查询模板用户菜单方法权限
	 * 
	 * @param role_id
	 * @return jt
	 */
	public List<RoleMenuVo> getPremissionByRoleId(Integer role_id) {
		// 查询得到店长模板的菜单方法列表
		Wrapper<SysRolePremission> rolePremissionWrapper = new EntityWrapper<SysRolePremission>().eq("role_id",
				role_id);
		List<SysRolePremission> premissionList = rolePremissionMapper.selectList(rolePremissionWrapper);

		if (premissionList.size() == 0) {
			// throw new BusinessException("","用户类型异常");

			System.err.println("用户类型异常");
		}

		ArrayList<Integer> menuIds = new ArrayList<>();
		for (SysRolePremission sysRolePremission : premissionList) {
			menuIds.add(sysRolePremission.getMenuId());
		}

		List<SysMenu> Menus = menuMapper.selectList(new EntityWrapper<SysMenu>().in("id", menuIds));

		Map<Integer, List<SysMenu>> pidToMenuList = getPidToMenuList(Menus);

		return getAllRoleMenuVo(Menus, pidToMenuList, premissionList, menuIds);
	}

	public List<RoleMenuVo> getRolePremission(Integer roleId, boolean needNoPremission) {
		Wrapper<SysRolePremission> rolePremissionWrapper = new EntityWrapper<SysRolePremission>().eq("role_id", roleId);
		List<SysRolePremission> rolePremissionList = rolePremissionMapper.selectList(rolePremissionWrapper);

		if (rolePremissionList.size() == 0 && !needNoPremission) {
			return null;
		}

		// 角色有的菜单
		Set<Integer> roleMenuIds = new HashSet<>();
		// 角色有的菜单对应的方法集合
		Map<Integer, Set<Integer>> roleMenuToMethod = new HashedMap();
		for (SysRolePremission rolePremission : rolePremissionList) {
			Integer menuId = rolePremission.getMenuId();
			roleMenuIds.add(menuId);

			if (rolePremission.getMethodId() == null) {
				continue;
			}

			if (roleMenuToMethod.containsKey(menuId)) {
				roleMenuToMethod.get(menuId).add(rolePremission.getMethodId());
			} else {
				Set<Integer> methods = new HashSet<>();
				methods.add(rolePremission.getMethodId());
				roleMenuToMethod.put(menuId, methods);
			}
		}

		List<RoleMenuVo> allMenuVo = getAllPremission();

		for (RoleMenuVo menuVo : allMenuVo) {
			List<RoleMenuVo> childrenn = menuVo.getChildren();

			if (childrenn == null) {
				continue;
			}

			for (RoleMenuVo childMenu : childrenn) {
				if (roleMenuIds.contains(childMenu.getId())) {
					childMenu.setContain(true);
					changeMethods(childMenu.getAllMethod(), roleMenuToMethod.get(childMenu.getId()));
				} else {
					childMenu.setContain(false);
					changeMethods(childMenu.getAllMethod(), new HashSet<>());
				}
			}

			if (allMenuIsFalse(childrenn)) {
				menuVo.setContain(false);
			}
		}
		//
		// 需要返回 没有权限的菜单。
		if (needNoPremission) {
			return allMenuVo;
		} else {
			List<RoleMenuVo> needMenuVo = new ArrayList<>();
			for (RoleMenuVo menuVo : allMenuVo) {
				if (!menuVo.isContain()) {
					continue;
				}

				List<RoleMenuVo> childrenn = menuVo.getChildren();
				menuVo.setChildren(new ArrayList<>());
				for (RoleMenuVo child : childrenn) {
					if (!child.isContain()) {
						continue;
					}

					List<RoleMethodVo> allMethod = child.getAllMethod();
					List<RoleMethodVo> containMethod = getContainMethod(allMethod);
					child.setAllMethod(containMethod);
					menuVo.getChildren().add(child);
				}

				needMenuVo.add(menuVo);
			}
		}

		return allMenuVo;
	}

	/**
	 *
	 * @param roleId
	 * @param needNoPremission
	 * @param userType
	 * @return
	 */
	public List<RoleMenuVo> getRoleModelPremission(Integer roleId, boolean needNoPremission, Integer userType) {
		Wrapper<SysRolePremission> rolePremissionWrapper = new EntityWrapper<SysRolePremission>().eq("role_id", roleId);
		List<SysRolePremission> rolePremissionList = rolePremissionMapper.selectList(rolePremissionWrapper);

		if (rolePremissionList.size() == 0 && !needNoPremission) {
			return null;
		}

		// 角色有的菜单
		Set<Integer> roleMenuIds = new HashSet<>();
		// 角色有的菜单对应的方法集合
		Map<Integer, Set<Integer>> roleMenuToMethod = new HashedMap();
		for (SysRolePremission rolePremission : rolePremissionList) {
			Integer menuId = rolePremission.getMenuId();
			roleMenuIds.add(menuId);

			if (rolePremission.getMethodId() == null) {
				continue;
			}

			if (roleMenuToMethod.containsKey(menuId)) {
				roleMenuToMethod.get(menuId).add(rolePremission.getMethodId());
			} else {
				Set<Integer> methods = new HashSet<>();
				methods.add(rolePremission.getMethodId());
				roleMenuToMethod.put(menuId, methods);
			}
		}

		List<RoleMenuVo> allMenuVo = getPremissionByRoleId(userType);

		for (RoleMenuVo menuVo : allMenuVo) {
			List<RoleMenuVo> childrenn = menuVo.getChildren();

			if (childrenn == null) {
				continue;
			}

			for (RoleMenuVo childMenu : childrenn) {
				if (roleMenuIds.contains(childMenu.getId())) {
					childMenu.setContain(true);
					changeMethods(childMenu.getAllMethod(), roleMenuToMethod.get(childMenu.getId()));
				} else {
					childMenu.setContain(false);
					changeMethods(childMenu.getAllMethod(), new HashSet<>());
				}
			}

			if (allMenuIsFalse(childrenn)) {
				menuVo.setContain(false);
			}
		}

		// 需要返回 没有权限的菜单。
		if (needNoPremission) {
			return allMenuVo;
		} else {
			List<RoleMenuVo> needMenuVo = new ArrayList<>();
			for (RoleMenuVo menuVo : allMenuVo) {
				if (!menuVo.isContain()) {
					continue;
				}

				List<RoleMenuVo> childrenn = menuVo.getChildren();
				menuVo.setChildren(new ArrayList<>());
				for (RoleMenuVo child : childrenn) {
					if (!child.isContain()) {
						continue;
					}

					List<RoleMethodVo> allMethod = child.getAllMethod();
					List<RoleMethodVo> containMethod = getContainMethod(allMethod);
					child.setAllMethod(containMethod);
					menuVo.getChildren().add(child);
				}

				needMenuVo.add(menuVo);
			}
		}

		return allMenuVo;
	}

	private boolean allMenuIsFalse(List<RoleMenuVo> childrenn) {
		if (childrenn == null || childrenn.size() == 0) {
			return true;
		}

		for (RoleMenuVo roleMenuVo : childrenn) {
			if (roleMenuVo.isContain()) {
				return false;
			}
		}

		return true;
	}

	private List<RoleMethodVo> getContainMethod(List<RoleMethodVo> childrenn) {
		if (childrenn == null || childrenn.size() == 0) {
			return null;
		}

		List<RoleMethodVo> containMethods = new ArrayList<>();
		for (RoleMethodVo methodVo : childrenn) {
			if (methodVo.isContain()) {
				containMethods.add(methodVo);
			}
		}

		return containMethods;
	}

	private void changeMethods(List<RoleMethodVo> allMethod, Set<Integer> containMethod) {
		if (allMethod == null) {
			return;
		}

		for (RoleMethodVo roleMethodVo : allMethod) {
			if (containMethod == null || !containMethod.contains(roleMethodVo.getId())) {
				roleMethodVo.setContain(false);
			}
		}
	}

	private List<RoleMenuVo> getAllRoleMenuVo(List<SysMenu> allMenus, Map<Integer, List<SysMenu>> pidToMenuList) {
		List<RoleMenuVo> list = new ArrayList<>();

		Map<Integer, SysMethod> idToMethod = getIdToMethod();

		Map<Integer, List<Integer>> menuIdToMethodIds = getMenuIdToMethodIds();

		for (SysMenu menu : allMenus) {
			// menu.status没有2的状态 将menu.getStatus!=2
			// 修改未menu.getStatus!=1(菜单状态不是删除状态)-jt 3/19
			if (menu.getLevel() == 1 && menu.getStatus() != 1) {
				RoleMenuVo roleMenuVo = getRoleMenuVo(menu);
				list.add(roleMenuVo);

				List<RoleMenuVo> childMenu = getChildMenu(menu.getId(), pidToMenuList, idToMethod, menuIdToMethodIds);
				roleMenuVo.setChildren(childMenu);
			}
		}

		Collections.sort(list, new Comparator<RoleMenuVo>() {
			@Override
			public int compare(RoleMenuVo menu1, RoleMenuVo menu2) {
				return menu1.getOrder() - menu2.getOrder();
			}
		});

		return list;
	}

	/**
	 *
	 * @param allMenus
	 * @param pidToMenuList
	 * @param premissionList
	 * @return jt
	 */
	private List<RoleMenuVo> getAllRoleMenuVo(List<SysMenu> allMenus, Map<Integer, List<SysMenu>> pidToMenuList,
			List<SysRolePremission> premissionList, ArrayList menuIds) {
		List<RoleMenuVo> list = new ArrayList<>();

		Map<Integer, SysMethod> idToMethod = getIdToMethod(premissionList);

		Map<Integer, List<Integer>> menuIdToMethodIds = getMenuIdToMethodIds(menuIds);

		for (SysMenu menu : allMenus) {
			// menu.status没有2的状态 将menu.getStatus!=2
			// 修改未menu.getStatus!=1(菜单状态不是删除状态)-jt 3/19
			if (menu.getLevel() == 1 && menu.getStatus() != 1) {
				RoleMenuVo roleMenuVo = getRoleMenuVo(menu);
				list.add(roleMenuVo);
				List<RoleMenuVo> childMenu = getChildMenu(menu.getId(), pidToMenuList, idToMethod, menuIdToMethodIds);
				roleMenuVo.setChildren(childMenu);

			} else if (menu.getLevel() == 2 && menu.getStatus() != 1) {
				List<SysMenu> parentMenu = getParentMenu(menu.getParentId());
				if (null == parentMenu || parentMenu.size() == 0) {
					continue;
				}
				SysMenu sysMenu = parentMenu.get(0);
				RoleMenuVo roleMenuVo = getRoleMenuVo(sysMenu);
				Integer x = 0;
				for (RoleMenuVo roleMenuVo1 : list) {
					if (roleMenuVo1.getId().equals(roleMenuVo.getId())) {
						x = 1;
						break;
					}
				}
				if (x == 0) {
					List<RoleMenuVo> childMenu1 = new ArrayList<>();
					List<RoleMenuVo> childMenu = getChildMenu(sysMenu.getId(), pidToMenuList, idToMethod,
							menuIdToMethodIds);
					for (RoleMenuVo roleMenuVo1 : childMenu) {
						if (roleMenuVo1.getId().equals(menu.getId())) {
							childMenu1.add(roleMenuVo1);
							break;
						}
					}
					roleMenuVo.setChildren(childMenu1);
					list.add(roleMenuVo);
				} else if (x == 1) {
					for (RoleMenuVo roleMenuVo2 : list) {
						if (x == 0) {
							break;
						}
						if (roleMenuVo2.getId().equals(sysMenu.getId())) {
							List<RoleMenuVo> childMenu = getChildMenu(sysMenu.getId(), pidToMenuList, idToMethod,
									menuIdToMethodIds);
							for (RoleMenuVo roleMenuVo3 : childMenu) {
								if (roleMenuVo3.getId().equals(menu.getId())) {
									roleMenuVo2.getChildren().add(roleMenuVo3);
									x = 0;
									break;
								}
							}
						}
						// // if(roleMenuVo1.getId()==menu.getParentId()){
						// //
						// roleMenuVo1.getChildren().add(getRoleMenuVo(menu));
						// // }
					}
				}
				// // List<RoleMenuVo> childMenu =
				// getChildMenu(menu.getParentId(),
				// // pidToMenuList, idToMethod, menuIdToMethodIds);
				// //
				// // roleMenuVo.setChildren(childMenu);
			}
		}

		Collections.sort(list, new Comparator<RoleMenuVo>() {
			@Override
			public int compare(RoleMenuVo menu1, RoleMenuVo menu2) {
				return menu1.getOrder() - menu2.getOrder();
			}
		});

		return list;
	}

	private Map<Integer, List<Integer>> getMenuIdToMethodIds() {
		List<SysMenuAllMethod> all = sysMenuAllMethodMapper.selectList(new EntityWrapper<>());
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (SysMenuAllMethod menuAllMethod : all) {
			if (map.containsKey(menuAllMethod.getMenuId())) {
				map.get(menuAllMethod.getMenuId()).add(menuAllMethod.getMethodId());
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(menuAllMethod.getMethodId());
				map.put(menuAllMethod.getMenuId(), list);
			}
		}

		return map;
	}

	private Map<Integer, List<Integer>> getMenuIdToMethodIds(ArrayList menuIds) {
		List<SysMenuAllMethod> all = sysMenuAllMethodMapper
				.selectList(new EntityWrapper<SysMenuAllMethod>().in("menu_id", menuIds));
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (SysMenuAllMethod menuAllMethod : all) {
			if (map.containsKey(menuAllMethod.getMenuId())) {
				map.get(menuAllMethod.getMenuId()).add(menuAllMethod.getMethodId());
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(menuAllMethod.getMethodId());
				map.put(menuAllMethod.getMenuId(), list);
			}
		}

		return map;
	}

	private List<RoleMenuVo> getChildMenu(Integer menuId, Map<Integer, List<SysMenu>> pidToMenu,
			Map<Integer, SysMethod> idToMethod, Map<Integer, List<Integer>> menuIdToMethodIds) {
		List<SysMenu> menuList = pidToMenu.get(menuId);
		if (menuList == null) {
			return new ArrayList<>();
		}

		List<RoleMenuVo> childMenu = new ArrayList<>();
		for (SysMenu menu : menuList) {
			RoleMenuVo roleMenuVo = getRoleMenuVo(menu);
			childMenu.add(roleMenuVo);
			List<RoleMethodVo> allMethod = getAllMethod(menu.getId(), menuIdToMethodIds, idToMethod);
			roleMenuVo.setAllMethod(allMethod);
		}

		Collections.sort(childMenu, new Comparator<RoleMenuVo>() {
			@Override
			public int compare(RoleMenuVo o1, RoleMenuVo o2) {
				return o1.getOrder() - o2.getOrder();
			}
		});

		return childMenu;
	}

	private List<RoleMethodVo> getAllMethod(Integer id, Map<Integer, List<Integer>> menuIdToMethodIds,
			Map<Integer, SysMethod> idToMethod) {
		List<Integer> methodIdList = menuIdToMethodIds.get(id);
		if (methodIdList == null) {
			return null;
		}
		List<RoleMethodVo> roleMenuVoList = new ArrayList<>();
		for (Integer methodId : methodIdList) {
			SysMethod method = idToMethod.get(methodId);
			RoleMethodVo methodVo = new RoleMethodVo();
			CachedBeanCopier.copy(method, methodVo);
			roleMenuVoList.add(methodVo);
		}

		return roleMenuVoList;
	}

	private RoleMenuVo getRoleMenuVo(SysMenu menu) {
		RoleMenuVo roleMenuVo = new RoleMenuVo();
		CachedBeanCopier.copy(menu, roleMenuVo);
		roleMenuVo.setLastLevel(menu.getIsLastLevel() == 1);
		return roleMenuVo;
	}

	private Map<Integer, SysMethod> getIdToMethod() {
		if (allIdToMethod != null) {
			return allIdToMethod;
		}

		List<SysMethod> methodList = methodMapper.selectList(new EntityWrapper<>());
		Map<Integer, SysMethod> map = new HashMap<>();
		for (SysMethod sysMethod : methodList) {
			map.put(sysMethod.getId(), sysMethod);
		}

		allIdToMethod = map;
		return map;
	}

	private Map<Integer, SysMethod> getIdToMethod(List<SysRolePremission> premissionList) {
		if (allIdToMethod != null) {
			return allIdToMethod;
		}

		ArrayList<Integer> methods = new ArrayList<>();
		for (SysRolePremission sysRolePremission : premissionList) {
			methods.add(sysRolePremission.getMethodId());
		}

		List<SysMethod> methodList = methodMapper.selectList(new EntityWrapper<SysMethod>().in("id", methods));

		Map<Integer, SysMethod> map = new HashMap<>();
		for (SysMethod sysMethod : methodList) {
			map.put(sysMethod.getId(), sysMethod);
		}

		allIdToMethod = map;
		return map;
	}

	private Map<Integer, List<SysMenu>> getPidToMenuList(List<SysMenu> sysMenus) {
		Map<Integer, List<SysMenu>> map = new HashMap<>();

		for (SysMenu menu : sysMenus) {
			if (menu.getLevel() == 2 && menu.getStatus() != 1) {
				if (map.containsKey(menu.getParentId())) {
					map.get(menu.getParentId()).add(menu);
				} else {
					List<SysMenu> list = new ArrayList<>();
					list.add(menu);
					map.put(menu.getParentId(), list);
				}
			}
		}

		return map;
	}

	private Map<Integer, SysMenu> getIdToMenu() {
		List<SysMenu> sysMenus = menuMapper.selectList(new EntityWrapper<>());

		Map<Integer, SysMenu> map = new HashMap<>();

		for (SysMenu menu : sysMenus) {
			if (menu.getLevel() == 2) {
				map.put(menu.getId(), menu);
			}
		}

		return map;
	}

	@Override
	public void afterPropertiesSet() {
		this.localCache = CacheBuilder.newBuilder().concurrencyLevel(2)// 并发级别,即允许最多2个线程并发更新,
																		// 默认值为4
				.expireAfterAccess(2, TimeUnit.HOURS) // 2小时没有被访问，则删除
				.initialCapacity(100).maximumSize(10000).build();
	}

	private List<SysMenu> getParentMenu(Integer parentMenuId) {
		Map<String, Object> queryMenuMap = new HashMap<>();
		queryMenuMap.put("id", parentMenuId);
		List<SysMenu> sysMenus = menuMapper.selectByMap(queryMenuMap);
		return sysMenus;
	}

}