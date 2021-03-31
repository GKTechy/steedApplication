package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.BillOfMaterialVO;

public interface BillOfMaterialDao {
	

	BillOfMaterialVO getAllBillOfMaterial();

	BillOfMaterialVO findBillOfMaterialbyId(int id);

	BillOfMaterialVO deleteBillOfMaterialbyId(int id);

	BillOfMaterialVO saveBillOfMaterial(BillOfMaterialVO obj);

	
	
}
