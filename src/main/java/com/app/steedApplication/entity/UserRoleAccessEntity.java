package com.app.steedApplication.entity;

import java.util.Date;

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
@Table(name="user_role_access")
public class UserRoleAccessEntity {
	
	public static final String TYPE = UserRoleAccessEntity.class.getName();

	@Id
	@Column(name = "role_access_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleAccessId;	
	
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="screen_id")
	private int screenId;
	
	@Column(name="read_access")
	private char readAccess;
	
	@Column(name="write_access")
	private char writeAccess;
	
	@Column(name="status")
	private char status;
	
	@Column(name="last_updated_dtm")
	private Date lastUpdatedDtm = null;
	
	@Column(name="last_updated_by")
	private String lastUpdatedBy = null;
	
	@Transient
	public boolean isChecked;
	
	@Transient
	public String displayStatus;
	
	@Transient
	public String readOnly;
	
	@Transient
	public String changeFlag;
		
}
