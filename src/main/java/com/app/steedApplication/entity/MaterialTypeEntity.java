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
@Table(name="material_type")
public class MaterialTypeEntity {

	public static final String TYPE = MaterialTypeEntity.class.getName();

	@Id
	@Column(name = "material_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int materialTypeId;	
	
	@Column(name="material_type_name")
	private String materialTypeName;

	@Column(name="material_type_description")
	private String materialTypeDescription;
	
	@Column(name = "is_active")
	public Boolean isActive;
	
	@Column(name = "created")
	public Date created;
	
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
