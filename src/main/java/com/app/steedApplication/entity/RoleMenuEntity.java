package com.app.steedApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="role_menu_mapping")
public class RoleMenuEntity {
	@Id
	@Column(name = "role_menu_mapping_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int roleMenuMapping_id;
	
	@Column(name = "roleId")
	public int roleId;
	
	@Column(name = "menu_id")
	public int menuId;
	
	@Column(name = "readOnly")
	public Boolean readOnly=false;
	
	@Column(name = "readWriteOnly")
	public Boolean readWriteOnly=false;
	
	
	
}
