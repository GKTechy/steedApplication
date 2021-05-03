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
@Table(name="dealer_order_products")
public class DealerOrderProductsEntity {
	
	@Id
	@Column(name = "seq_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int seqNo;

	@Column(name = "dealer_order_id")
	public int dealerOrderId;

	@Column(name = "product_id")
	public String productId;
	
	@Column(name = "order_code")
	public String orderCode;
	
	@Column(name = "qty")
	public String qty;
	
	@Column(name = "price")
	public String price;
	
	@Column(name = "gst")
	public String gst;
	
	@Column(name = "gst_amount")
	public String gstAmt;
	
	@Column(name = "amount")
	public String amount;
	
	
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
	public String dealerName;
	
	@Transient
	public String productName;
	
	@Transient
	public String size;
	
	@Transient
	public String colors;
	
}
