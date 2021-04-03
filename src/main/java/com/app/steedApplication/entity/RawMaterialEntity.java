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
@Table(name="raw_material")
public class RawMaterialEntity {
	@Id
	@Column(name = "raw_material_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int rawMaterialId;
	
	@Column(name = "raw_material_name")
	public String rawMaterialName;
	
	@Column(name = "material_code")
	public String materialCode;
	
	@Column(name = "item_type")
	public String itemType;
	
	@Column(name = "remarks")
	public String remarks;
	
	@Column(name = "measurement_type")
	public String measurementType;
	
	@Column(name = "units")
	public String units;
	
	@Column(name = "price")
	public String price;
	
	@Column(name = "reference_level")
	public String referenceLevel;
	
	@Column(name = "supplier_id")
	public int supplierId;
	
	
	@Column(name = "hsn_code")
	public String hsnCode;
	
	@Column(name = "is_bom")
	public String isBom;
	
	@Column(name = "is_active")
	public String isActive;
	
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
	
	@Transient
	public String supplierName;
	
}


