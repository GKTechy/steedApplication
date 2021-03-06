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
@Table(name="dealer_order")
public class DealerOrderEntity {
	@Id
	@Column(name = "dealer_order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int dealerOrderId;
	
	@Column(name = "order_no")
	public String orderNo;
	
	@Column(name = "order_for")
	public String orderFor;
	
	@Column(name = "order_date")
	public Date orderDate;
	
	@Column(name = "dealer_id")
	public int dealerId;
		
	@Column(name = "reference")
	public String reference;
	
	@Column(name = "subtotal")
	public String subtotal;
	
	@Column(name = "tax_total")
	public String taxTotal;
	
	@Column(name = "total")
	public String total;
	
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
	public String dealerContactPerson;
	
}
