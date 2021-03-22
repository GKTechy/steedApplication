package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.ProductEntity;

import lombok.Data;

@Data
public class ProductVO {
	


	public Boolean valid;
	public String responseMsg;
	public List<ProductEntity> productList;
	public ProductEntity productObj;
	
	
}
