package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.SupplierVO;

public interface SupplierService {

	SupplierVO getAllSupplier();

	SupplierVO findSupplierbyId(int id);

	SupplierVO deleteSupplierbyId(int id);

	SupplierVO saveSupplier(SupplierVO obj);

}
