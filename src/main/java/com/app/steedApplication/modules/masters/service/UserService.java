package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.entity.UserEntity;
import com.app.steedApplication.modules.masters.model.UserVO;

public interface UserService {


	UserVO getAllUsers();

	UserVO findUserbyId(int id);

	UserVO deleteUserbyId(int id);

	UserVO CreateOrUpdateUser(UserEntity user);

	public UserVO userLogin(String userName, String userPassword) throws Exception;

	public UserVO changePassword(String userName, String currentPassword, String newPassword) throws Exception;
	
	public UserVO forgotPassword(String userName, String currentPassword, String newPassword) throws Exception;
	
	public UserVO saveUserList(UserVO userVO) throws Exception;
	
	public UserVO deleteUser(int id, String employeeId, String loginUser, String companyCode) throws Exception;
	
	public UserVO resetPassword(UserVO userVO) throws Exception;
	
	
}
