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
	public Object getUOMList() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setUOMList(Object uomList2) {
		// TODO Auto-generated method stub
		
	}	
}
