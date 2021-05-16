package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.entity.UserEntity;
import com.app.steedApplication.modules.masters.dao.RoleDao;
import com.app.steedApplication.modules.masters.dao.UserDao;
import com.app.steedApplication.modules.masters.model.UserVO;
import com.app.steedApplication.modules.masters.service.UserService;



@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public UserVO getAllUsers() {
		UserVO returnobj = new UserVO();
		try {
			returnobj= userDao.getAllUsers();
			returnobj.setRoleList(roleDao.getAllRoles().getRoleList());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public UserVO findUserbyId(int id) {
		UserVO returnobj = new UserVO();
		try {
			returnobj= userDao.findUserbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public UserVO deleteUserbyId(int id) {
		UserVO returnobj = new UserVO();
		try {
			returnobj= userDao.deleteUserbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public UserVO CreateOrUpdateUser(UserEntity user) {
		UserVO returnobj = new UserVO();
		try {
			returnobj= userDao.CreateOrUpdateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public UserVO userLogin(String userName, String userPassword) throws Exception {
		UserVO returnobj = new UserVO();
		try {
			returnobj = userDao.userLogin(userName, userPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public UserVO changePassword(String userName, String currentPassword, String newPassword) throws Exception {
		UserVO returnobj = new UserVO();
		try {
			returnobj = userDao.changePassword(userName,currentPassword,newPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}
	
	@Override
	public UserVO forgotPassword(String userName, String currentPassword, String newPassword) throws Exception {
		UserVO returnobj = new UserVO();
		try {
			returnobj = userDao.forgotPassword(userName,currentPassword,newPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	
	
	@Override
	public UserVO saveUserList(UserVO userVO) throws Exception {
		UserVO returnobj = new UserVO();
		try {
			returnobj = userDao.saveUserList(userVO);
			
			returnobj.setUsersList(userDao.getAllUsers().getUsersList());
			returnobj.setRoleList(roleDao.getAllRoles().getRoleList());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}
	
	@Override
	public UserVO deleteUser(int id, String employeeId, String loginUser, String companyCode) throws Exception {
		UserVO returnobj = new UserVO();
		try {
			returnobj = userDao.deleteUser(id,employeeId,loginUser,companyCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}
	
	@Override
	public UserVO resetPassword(UserVO userVO) throws Exception {
		UserVO returnobj = new UserVO();
		try {
			returnobj = userDao.resetPassword(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	
}
