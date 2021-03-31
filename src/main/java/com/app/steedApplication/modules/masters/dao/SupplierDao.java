package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.SupplierVO;

public interface SupplierDao {
	
	SupplierVO getAllSupplier();

	SupplierVO findSupplierbyId(int id);

	SupplierVO deleteSupplierbyId(int id);

	SupplierVO saveSupplier(SupplierVO obj);
}
