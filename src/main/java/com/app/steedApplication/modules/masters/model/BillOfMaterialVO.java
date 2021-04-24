package com.app.steedApplication.modules.masters.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.app.steedApplication.entity.BOMEntity;
import com.app.steedApplication.entity.ProductEntity;

import lombok.Data;

@Data
public class BillOfMaterialVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<BOMEntity> BOMList;
	public BOMEntity BOMObj;

	public List<ProductEntity> productList;
	public ProductEntity productObj;
	
	
	public List<BillOfMaterialVO> bomProductList;
	
	public BigInteger billOfMaterialId;
	public int productId;
	public String productName;
	public String productCode;
	public String measurementType;
	public String measurementName;
	public String qty;
	public String uomType;
	public Boolean rowSelected=false;
	
	
	public String createdBy;
	public String updatedBy;	
		
}
