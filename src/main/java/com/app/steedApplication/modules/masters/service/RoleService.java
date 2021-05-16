package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.RoleVO;

public interface RoleService {

	RoleVO getAllRoles();

	RoleVO findRolebyId(int id);

	RoleVO deleteRolebyId(int id);

	RoleVO saveRole(RoleVO obj);

	RoleVO allRolesModules();

}
