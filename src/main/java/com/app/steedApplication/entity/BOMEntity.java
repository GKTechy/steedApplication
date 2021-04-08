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
@Table(name="bill_of_material")
public class BOMEntity {
	@Id
	@Column(name = "bill_of_material_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int billOfMaterialId;
	
	@Column(name = "itemtype_id")
	public int itemtypeId;
	
	@Column(name = "bill_of_material_item_id")
	public int itemId;
	
	@Column(name = "bill_of_material_item_quantity")
	public int quantity;
	
	@Column(name = "bill_of_material_uom_id")
	public int uomId;
	
	@Column(name = "product_id")
	public int productId;
	
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
	
	
	
}
