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
@Table(name="menu")
public class MenuEntity {
	@Id
	@Column(name = "menu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int menuId;
	
	@Column(name = "menu_name")
	public String menuName;
	
	@Column(name = "main_menu_id")
	public int mainMenuId;
	
	@Column(name = "sub_menu_id")
	public int subMenuId;
	
	@Transient
	public String mainMenuName;
	
	@Transient
	public String subMenuName;
	
	@Transient
	public Boolean readOnly=false;
	
	@Transient
	public Boolean readWriteOnly=false;
	
	
	
}
