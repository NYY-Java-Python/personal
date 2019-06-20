package com.lingku.xundao.systemmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingku.xundao.systemmanager.mapper.RoleMapper;
import com.lingku.xundao.systemmanager.pojo.RoleInfo;

@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;

	public List<RoleInfo> roleInfo() {

		return roleMapper.roleInfo();
	}

	public Integer addRoel(RoleInfo roleInfo) {

		return roleMapper.addRoel(roleInfo);
	}

	public Integer udpateRoleInfo(RoleInfo roleInfo) {
		
		return roleMapper.udpateRoleInfo(roleInfo);
	}

	public Integer delRoleInfo(Integer roleId) {
		
		return roleMapper.delRoleInfo(roleId);
	}

	public Integer delMulitRoleInfo(Integer[] ids) {
		
		return roleMapper.delMulitRoleInfo(ids);
	}

}
