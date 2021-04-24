package com.app.steedApplication.modules.masters.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.steedApplication.modules.masters.dao.BillOfMaterialDao;
import com.app.steedApplication.modules.masters.dao.ProductDao;
import com.app.steedApplication.modules.masters.dao.RawMaterialDao;
import com.app.steedApplication.modules.masters.model.BillOfMaterialVO;
import com.app.steedApplication.modules.masters.service.BillOfMaterialService;

@Service
@Transactional
public class BillOfMaterialServiceImpl implements BillOfMaterialService {
	
	@Autowired
	private BillOfMaterialDao billOfMaterialDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private RawMaterialDao rawMaterialDao;
		
	
	
	@Override
	public BillOfMaterialVO getAllBillOfMaterial() {
		BillOfMaterialVO returnobj = new BillOfMaterialVO();
		try {
			returnobj= billOfMaterialDao.getAllBillOfMaterial();
			returnobj.setProductList(productDao.getAllProducts().getProductList());
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
			returnobj.setProductList(productDao.getAllProducts().getProductList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public BillOfMaterialVO productBoms(int productId) {
		BillOfMaterialVO returnobj = new BillOfMaterialVO();
		try {
			returnobj= billOfMaterialDao.productBoms(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}



	

}
