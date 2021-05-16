package com.app.steedApplication.modules.masters.model;

import java.util.List;
import java.util.Map;

import com.app.steedApplication.entity.UserEntity;
import com.app.steedApplication.entity.UserRoleEntity;

import lombok.Data;

@Data
public class UserVO {
	
	
	public Boolean valid;
	public String responseMsg;
	public List<UserEntity> usersList;
	public UserEntity userObj;
	
	public int id = 0;
	public String userName;
	public String loginUserId;
	public String password;
	public String userType;
	public String employeeId;
	public String erpUserId;
	public String reportTo;
	public String distributorCode;
	public String phoneNumber;
	public String eMail;
	public String brandCode;
	public String deviceId;
	public String expiryDate;
	public String passwordChange;
	public String userStatus;
	public int rolePosition = 0;
	public int userTypePosition = 0;
	public String employeeNumber;
	
	public String language;
	public String displayImageInOrder;
	public String status;
	
	public String companyCode;
	public String loginUser;
	
	public Boolean changeFlag = false;
	public String oldPassword;
	public String resetPassword;
	public Boolean oldPasswordFlag = false;
	
	
	public List<UserRoleEntity> roleList;
	
	
	
}
