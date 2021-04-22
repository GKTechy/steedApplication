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
@Table(name="product")
public class ProductEntity {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int productId;
	
	@Column(name = "product_name")
	public String productName;
	
	@Column(name = "product_shortname")
	public String productShortname;
	
	@Column(name = "product_code")
	public String productCode;

	@Column(name = "order_code")
	public String orderCode;
	
	@Column(name = "size")
	public String size;
	
	@Column(name = "colors")
	public String colors;

	@Column(name = "varient_id")
	public String varientId;
	
	@Column(name = "transmission")
	public String transmission;

	@Column(name = "frame")
	public String frame;
	
	@Column(name = "description")
	public String description;
	
	@Column(name = "category")
	public String category;
	
	@Column(name = "image")
	public String image;
	
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
