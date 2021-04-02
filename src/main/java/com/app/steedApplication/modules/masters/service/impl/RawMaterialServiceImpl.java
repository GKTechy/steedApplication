package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.ProductDao;
import com.app.steedApplication.modules.masters.dao.RawMaterialDao;
import com.app.steedApplication.modules.masters.dao.SupplierDao;
import com.app.steedApplication.modules.masters.model.ProductVO;
import com.app.steedApplication.modules.masters.model.RawMaterialVO;
import com.app.steedApplication.modules.masters.service.RawMaterialService;

@Service
@Transactional
public class RawMaterialServiceImpl implements RawMaterialService {
	@Autowired
	private RawMaterialDao rawMaterialDao;
		
	@Autowired
	private SupplierDao supplierDao;
	
	@Override
	public RawMaterialVO getAllRawMaterials() {
		RawMaterialVO returnobj = new RawMaterialVO();
		try {
			returnobj= rawMaterialDao.getAllRawMaterials();
			returnobj.setSupplierList(supplierDao.getAllSupplier().getSupplierList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public RawMaterialVO findRawMaterialbyId(int id) {
		RawMaterialVO returnobj = new RawMaterialVO();
		try {
			returnobj= rawMaterialDao.findRawMaterialbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public RawMaterialVO deleteRawMaterialbyId(int id) {
		RawMaterialVO returnobj = new RawMaterialVO();
		try {
			returnobj= rawMaterialDao.deleteRawMaterialbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public RawMaterialVO saveRawMaterial(RawMaterialVO obj) {
		RawMaterialVO returnobj = new RawMaterialVO();
		try {
			returnobj= rawMaterialDao.saveRawMaterial(obj) ;
			returnobj.setRawMaterialList(rawMaterialDao.getAllRawMaterials().getRawMaterialList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

}
