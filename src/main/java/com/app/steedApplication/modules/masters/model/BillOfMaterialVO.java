package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.BOMEntity;
import lombok.Data;

@Data

public class BillOfMaterialVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<BOMEntity> BOMList;
	public BOMEntity BOMObj;

}
