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
@Table(name="user_roles")
public class UserRoleEntity {
	
	public static final String TYPE = UserRoleAccessEntity.class.getName();

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;	
	
	@Column(name="company_code")
	private String companyCode;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="create_salesman")
	private char createSalesman;
	
	@Column(name="status")
	private char status;
	
	@Column(name="last_updated_dtm")
	private Date lastUpdatedDtm = null;
	
	@Column(name="last_updated_by")
	private String lastUpdatedBy = null;	
	
	@Transient
	public String displayCreateSalesman;
	
	@Transient
	public String displayStatus;
	
	@Transient
	public String readOnly;
	
	@Transient
	public String changeFlag;
		
}
