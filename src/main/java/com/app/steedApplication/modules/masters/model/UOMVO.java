package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.UOMEntity;

import lombok.Data;

@Data
public class UOMVO {

	
	public Boolean valid;
	public String responseMsg;
	public List<UOMEntity> uomList;
	public UOMEntity uomObj;
	
}
