package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.DealerOrderEntity;

import lombok.Data;

public class DealerOrderVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<DealerOrderEntity> dealerOrderList;
	public DealerOrderEntity dealerOrderObj;

}