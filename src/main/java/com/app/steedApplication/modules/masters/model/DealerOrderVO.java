package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.DealerOrderEntity;
import com.app.steedApplication.entity.ProductEntity;

import lombok.Data;

@Data
public class DealerOrderVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<DealerOrderEntity> dealerOrderList;
	public DealerOrderEntity dealerOrderObj;
	
	public List<DealerEntity> dealerList;
	public List<ProductEntity> productList;
	
 
}
