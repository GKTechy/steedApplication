package com.app.steedApplication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_roles_mapping")
public class UserRoleMappingEntity implements Serializable, Cloneable {
	
	public static final String TYPE = UserRoleMappingEntity.class.getName();

	@Id
	@Column(name = "user_id")
	private int userId;	

	@Id
	@Column(name = "role_id")
	private int roleId;	
	
	
}
