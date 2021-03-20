package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.MaterialTypeEntity;

import lombok.Data;

@Data
public class MaterialTypeVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<MaterialTypeEntity> materialTypeList;
	public MaterialTypeEntity materialTypeObj;
	
}
