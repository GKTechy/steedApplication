package com.app.steedApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sub_menu")
public class SubMenuEntity {
	@Id
	@Column(name = "sub_menu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int subMenuId;
	
	@Column(name = "sub_menu_name")
	public String subMenuName;
	
	
	@Column(name = "main_menu_id")
	public int mainMenuId;
	
	@Column(name = "icon")
	public String icon;
	
	@Column(name = "component")
	public String component;
		
}
