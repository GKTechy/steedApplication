package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.BOMEntity;
import com.app.steedApplication.entity.MaterialTypeEntity;
import com.app.steedApplication.entity.RawMaterialEntity;
import com.app.steedApplication.entity.SequenceEntity;
import com.app.steedApplication.entity.SupplierEntity;
import com.app.steedApplication.entity.UOMEntity;

import lombok.Data;

@Data
public class RawMaterialVO {
	
	

	public Boolean valid;
	public String responseMsg;
	public List<RawMaterialEntity> rawMaterialList;
	public RawMaterialEntity rawMaterialObj;
	
	public List<SupplierEntity> supplierList;
	public List<MaterialTypeEntity> materialTypeList;
	public List<UOMEntity> uomList;
	
	
	public List<SequenceEntity> seqList;
	
	
}
