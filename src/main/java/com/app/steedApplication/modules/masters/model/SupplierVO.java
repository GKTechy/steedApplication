package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.SequenceEntity;
import com.app.steedApplication.entity.SupplierEntity;

import lombok.Data;
@Data
public class SupplierVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<SupplierEntity> supplierList;
	public SupplierEntity supplierObj;
	
	public SequenceEntity sObj;
	

}
