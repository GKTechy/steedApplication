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
@Table(name="machine")
public class MachineEntity {
	@Id
	@Column(name = "machine_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long machineId;
	
	@Column(name = "machine_name")
	public String machineName;
	
	@Column(name = "machine_code")
	public String machineCode;
	
	@Column(name = "make")
	public String make;
	
	@Column(name = "type")
	public String type;
	
	@Column(name = "commissioning_date")
	public Date commissioningDate;
	
	@Column(name = "dispote_date")
	public Date dispoteDate;
	
	@Column(name = "inv_no")
	public String invNo;
	
	@Column(name = "inv_date")
	public Date invDate;
	
	@Column(name = "inv_value")
	public String invValue;
	
	@Column(name = "location")
	public String location;
	
	@Column(name = "status")
	public String status;
	
	@Column(name = "capacity")
	public String capacity;
	
	@Column(name = "is_qc_machine")
	public String isQcMachine;
	
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
