package com.app.steedApplication.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnTransformer;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name="user")
@Data
public class UserEntity implements Serializable, Cloneable {
	
	public static final String TYPE = UserEntity.class.getName();
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int userId;
	
	@Column(name = "user_name")
	public String userName;
	
	@Column(name = "password")
	@ColumnTransformer(
//			read = "cast(AES_DECRYPT(password, 'steed_app') as char(255))",
			write = "AES_ENCRYPT(?, 'steed_app')"
			)
	public String password;

	@Column(name = "display_name")
	public String displayName;
	
	@Column(name = "pwdtobechanged")
	public String pwdToBeChanged;
	
	@Column(name = "expirydate")
	public Date expiryDate;
	
	@Column(name = "status")
	public String status;
	
	@Column(name = "created")
	public Date created;
	
	@Column(name = "created_by")
	public String createdBy;
	
	@Column(name = "updated")
	public Date updated;
	
	@Column(name = "updated_by")
	public String updatedBy;
	
	@Transient
	public String userRoles;
	
	@Transient
	public List<MainMenuEntity> menuList;
}
