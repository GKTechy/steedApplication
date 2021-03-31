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
@Table(name="supplier")
public class SupplierEntity {
	@Id
	@Column(name = "supplier_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long supplierId;
	
	@Column(name = "supplier_name")
	public String supplierName;
	
	@Column(name = "supplier_code")
	public String supplierCode;
	
	@Column(name = "supplier_contact_person")
	public String supplierContactPerson;
	
	@Column(name = "mobile")
	public String mobile;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "fax")
	public String fax;
	
	@Column(name = "gst")
	public String gst;
	
	@Column(name = "pan")
	public String pan;
	
	@Column(name = "remarks")
	public String remarks;
		
	@Column(name = "address")
	public String address;
	
	@Column(name = "city")
	public String city;
	
	@Column(name = "state")
	public String state;
	
	@Column(name = "pin_code")
	public String pinCode;
	
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
