package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.steedApplication.modules.masters.dao.BillOfMaterialDao;
import com.app.steedApplication.modules.masters.model.BillOfMaterialVO;
import com.app.steedApplication.modules.masters.service.BillOfMaterialService;

public class BillOfMaterialServiceImpl implements BillOfMaterialService {
	
	@Autowired
	private BillOfMaterialDao billOfMaterialDao;

	
	@Override
	public BillOfMaterialVO getAllBillOfMaterial() {
		BillOfMaterialVO returnobj = new BillOfMaterialVO();
		try {
			returnobj= billOfMaterialDao.getAllBillOfMaterial();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}
	

	@Override
	public BillOfMaterialVO findBillOfMaterialbyId(int id) {
		BillOfMaterialVO returnobj = new BillOfMaterialVO();
		try {
			returnobj= billOfMaterialDao.findBillOfMaterialbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public BillOfMaterialVO deleteBillOfMaterialbyId(int id) {
		BillOfMaterialVO returnobj = new BillOfMaterialVO();
		try {
			returnobj= billOfMaterialDao.deleteBillOfMaterialbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public BillOfMaterialVO saveBillOfMaterial(BillOfMaterialVO obj) {
		BillOfMaterialVO returnobj = new BillOfMaterialVO();
		try {
			returnobj= billOfMaterialDao.saveBillOfMaterial(obj) ;
			returnobj.setBOMList(billOfMaterialDao.getAllBillOfMaterial().getBOMList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}



	

}
