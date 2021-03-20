package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.RoleDao;
import com.app.steedApplication.modules.masters.dao.UserDao;
import com.app.steedApplication.modules.masters.model.RoleVO;
import com.app.steedApplication.modules.masters.model.UserVO;
import com.app.steedApplication.modules.masters.service.RoleService;



@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	
	@Override
	public RoleVO getAllRoles() {
		RoleVO returnobj = new RoleVO();
		try {
			returnobj= roleDao.getAllRoles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public RoleVO findRolebyId(int id) {
		RoleVO returnobj = new RoleVO();
		try {
			returnobj= roleDao.findRolebyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public RoleVO deleteRolebyId(int id) {
		RoleVO returnobj = new RoleVO();
		try {
			returnobj= roleDao.deleteRolebyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public RoleVO saveRole(RoleVO obj) {
		RoleVO returnobj = new RoleVO();
		try {
			returnobj= roleDao.saveRole(obj) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	

}