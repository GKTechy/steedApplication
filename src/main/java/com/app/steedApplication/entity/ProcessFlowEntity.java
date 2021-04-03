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
@Table(name="process_flow")
public class ProcessFlowEntity {
	@Id
	@Column(name = "process_flow_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int processFlowId;
	
	@Column(name = "product_id")
	public int productId;
	
	@Column(name = "process_id")
	public int processId;
	
	@Column(name = "operation_no")
	public int operationNo;
	
	@Column(name = "cycle_time")
	public String cycleTime;
	
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
	public String processName;
	
	@Transient
	public String productName;
	
	
	
}
