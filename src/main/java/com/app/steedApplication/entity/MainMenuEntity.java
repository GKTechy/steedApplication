package com.app.steedApplication.entity;

import java.util.List;

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
@Table(name="main_menu")
public class MainMenuEntity {
	
	@Id
	@Column(name = "main_menu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int mainMenuId;
	
	@Column(name = "main_menu_name")
	public String mainMenuName;
	
	@Column(name = "icon")
	public String icon;
	
	@Transient
	public List<SubMenuEntity> subMenuList;
	
	
}
