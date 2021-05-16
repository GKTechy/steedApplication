package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.RoleVO;

public interface RoleDao {

	RoleVO getAllRoles();

	RoleVO deleteRolebyId(int id);

	RoleVO findRolebyId(int id);

	RoleVO saveRole(RoleVO obj);

	RoleVO allRolesModules();

}
