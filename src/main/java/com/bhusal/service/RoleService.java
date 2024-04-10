package com.bhusal.service;

import java.util.List;

import com.bhusal.dto.RoleDto;

public interface RoleService {
	
	RoleDto addRole(RoleDto roleDto);
	RoleDto findRoleById(int roleId);
	RoleDto updateRole(RoleDto rDto);
	List<RoleDto> findRoles();
	void deleteRole(int id);

}
