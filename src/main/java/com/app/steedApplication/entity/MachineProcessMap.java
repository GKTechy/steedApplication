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
@Table(name="machine_process_map")
public class MachineProcessMap {
	@Id
	@Column(name = "machine_process_map_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int machineProcessMapId;
	
	@Column(name = "machine_name_id")
	public int machineNameId;
	
	@Column(name = "process_id")
	public int processId;
	
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
	public String machineName;
	
	@Transient
	public String processName;
}
