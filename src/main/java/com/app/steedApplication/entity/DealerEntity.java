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
@Table(name="dealer")
public class DealerEntity {
	
	@Id
	@Column(name = "dealer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long dealerId;
	
	@Column(name = "dealer_name")
	public String dealerName;
	
	@Column(name = "dealer_code")
	public String dealerCode;
	
	@Column(name = "dealer_phone")
	public String dealerPhone;
	
	@Column(name = "dealer_contact_person")
	public String dealerContactPerson;
	
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
	
	@Column(name = "is_default_address")
	public String isDefaultAddress;
	
	@Column(name = "address_name")
	public String addressName;
	
	@Column(name = "address_1")
	public String address1;
	
	@Column(name = "address_2")
	public String address2;
	
	@Column(name = "address_3")
	public String address3;
	
	@Column(name = "city")
	public String city;
	
	@Column(name = "state")
	public String state;
	
	@Column(name = "phone")
	public String phone;
	
	@Column(name = "phone2")
	public String phone2;
	
	@Column(name = "phone3")
	public String phone3;
	
	@Column(name = "contry")
	public String contry;
	
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
