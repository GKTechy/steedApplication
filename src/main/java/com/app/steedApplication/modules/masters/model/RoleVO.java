package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.MainMenuEntity;
import com.app.steedApplication.entity.UserRoleEntity;

import lombok.Data;


@Data
public class RoleVO {

	public Boolean valid;
	public String responseMsg;
	public List<UserRoleEntity> roleList;
	public UserRoleEntity roleObj;
	
	
	public List<MainMenuEntity> mainMenuList;
	
}
