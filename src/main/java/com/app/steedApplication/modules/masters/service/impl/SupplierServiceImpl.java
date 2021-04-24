package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.SupplierDao;
import com.app.steedApplication.modules.masters.model.SupplierVO;
import com.app.steedApplication.modules.masters.service.SupplierService;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDao;

	
	@Override
	public SupplierVO getAllSupplier() {
		SupplierVO returnobj = new SupplierVO();
		try {
			returnobj= supplierDao.getAllSupplier();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}
	

	@Override
	public SupplierVO findSupplierbyId(int id) {
		SupplierVO returnobj = new SupplierVO();
		try {
			returnobj= supplierDao.findSupplierbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public SupplierVO deleteSupplierbyId(int id) {
		SupplierVO returnobj = new SupplierVO();
		try {
			returnobj= supplierDao.deleteSupplierbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public SupplierVO saveSupplier(SupplierVO obj) {
		SupplierVO returnobj = new SupplierVO();
		try {
			returnobj= supplierDao.saveSupplier(obj) ;
			returnobj.setSupplierList(supplierDao.getAllSupplier().getSupplierList());
			returnobj.setSObj(supplierDao.getAllSupplier().getSObj());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

}
