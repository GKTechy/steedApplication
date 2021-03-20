package com.app.steedApplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bill_of_material")
public class BOMEntity {
	@Id
	@Column(name = "bill_of_material_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int billOfMaterialId;
	
	@Column(name = "bill_of_material_itemtype_id")
	public int billOfMaterialItemtypeId;
	
	@Column(name = "bill_of_material_item_id")
	public int billOfMaterialItemId;
	
	@Column(name = "bill_of_material_item_quantity")
	public int billOfMaterialItemQuantity;
	
	@Column(name = "bill_of_material_uom_id")
	public int billOfMaterialUomId;
	
	@Column(name = "bill_of_material_product_id")
	public int billOfMaterialProductId;
	
	
	
}
