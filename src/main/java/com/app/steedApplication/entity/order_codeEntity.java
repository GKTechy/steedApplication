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
@Table(name="order_code")
public class order_codeEntity {
	@Id
	@Column(name = "order_code_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long orderCodeId;
	
	@Column(name = "color_code")
	public String colorCode;
	
	@Column(name = "is_active")
	public String isActive;
	
	@Column(name = "created")
	public String created;
	
	@Column(name = "created_by")
	public String createdBy;
	
	@Column(name = "updated")
	public Date updated;
	
	@Column(name = "updated_by")
	public String updatedBy;	
		
	@Transient
	public String readOnly;
	
	@Transient
	public String changeFlag;
	
}
