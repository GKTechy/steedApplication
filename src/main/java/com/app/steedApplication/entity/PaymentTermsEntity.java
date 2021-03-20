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
@Table(name="payment_terms")
public class PaymentTermsEntity {
	
	public static final String TYPE = PaymentTermsEntity.class.getName();

	@Id
	@Column(name = "payment_terms_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentTermsId;	
	
	@Column(name = "description")
	public String description;
	
	@Column(name = "content")
	public String content;
	
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
