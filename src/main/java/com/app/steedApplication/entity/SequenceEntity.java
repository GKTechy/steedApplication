package com.app.steedApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sequence_table")
public class SequenceEntity {
		
	
	
	@Id
	@Column(name = "value")
	public String value;
	
	@Column(name = "currentnext")
	public String currentNext;
	
	
}
