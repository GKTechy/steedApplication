package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.ProcessEntity;
import com.app.steedApplication.entity.ProcessFlowEntity;
import com.app.steedApplication.entity.ProductEntity;

import lombok.Data;

@Data
public class ProcessFlowVO {

	public Boolean valid;
	public String responseMsg;
	public List<ProcessFlowEntity> processFlowList;
	public ProcessFlowEntity processFlowObj;
	
	
	public List<ProcessEntity> processList;
	public List<ProductEntity> productList;
	
}
