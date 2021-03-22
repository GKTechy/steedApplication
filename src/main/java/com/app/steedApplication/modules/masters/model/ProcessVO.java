package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.ProcessEntity;

import lombok.Data;

@Data
public class ProcessVO {
	

	public Boolean valid;
	public String responseMsg;
	public List<ProcessEntity> processList;
	public ProcessEntity processObj;
	
	
}
