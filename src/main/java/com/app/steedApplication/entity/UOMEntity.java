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
@Table(name="unit_of_measurement")
public class UOMEntity {
	@Id
	@Column(name = "unit_of_measurement_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long unitOfMeasurementId;
	
	@Column(name = "measurement_name")
	public String measurementName;
	
	@Column(name = "measurement_short_name")
	public String measurementShortName;
	
	
	@Column(name = "measurement_type_id")
	public String measurementTypeId;
	
	@Column(name = "base_measurement")
	public String baseMeasurement;
	
	
	@Column(name = "equivalent_value_with_base")
	public String equivalentValueWithBase;
	
	@Column(name = "description")
	public String description;
	
	@Column(name = "varied_measurement")
	public String variedMeasurement;
	
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
	
	
	
	
	

