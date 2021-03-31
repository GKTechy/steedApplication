package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.BillOfMaterialVO;

public interface BillOfMaterialService {

	BillOfMaterialVO getAllBillOfMaterial();

	BillOfMaterialVO findBillOfMaterialbyId(int id);

	BillOfMaterialVO deleteBillOfMaterialbyId(int id);

	BillOfMaterialVO saveBillOfMaterial(BillOfMaterialVO obj);

	

}
