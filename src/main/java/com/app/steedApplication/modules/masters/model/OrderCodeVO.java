package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.OrderCodeEntity;

import lombok.Data;

@Data
public class OrderCodeVO {


	public Boolean valid;
	public String responseMsg;
	public List<OrderCodeEntity> orderCodeList;
	public OrderCodeEntity orderCodeObj;
	
	
}
