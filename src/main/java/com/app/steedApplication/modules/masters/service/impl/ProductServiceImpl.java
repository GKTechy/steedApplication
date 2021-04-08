package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.ProductDao;
import com.app.steedApplication.modules.masters.model.ProductVO;
import com.app.steedApplication.modules.masters.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	

	@Autowired
	private ProductDao productDao;

	
	@Override
	public ProductVO getAllProducts() {
		ProductVO returnobj = new ProductVO();
		try {
			returnobj= productDao.getAllProducts();
			returnobj.setProductVarientList(productDao.allProductVarients().getProductVarientList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProductVO findProductbyId(int id) {
		ProductVO returnobj = new ProductVO();
		try {
			returnobj= productDao.findProductbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProductVO deleteProductbyId(int id) {
		ProductVO returnobj = new ProductVO();
		try {
			returnobj= productDao.deleteProductbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProductVO saveProduct(ProductVO obj) {
		ProductVO returnobj = new ProductVO();
		try {
			returnobj= productDao.saveProduct(obj) ;
			returnobj.setProductList(productDao.getAllProducts().getProductList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProductVO allProductVarients() {
		ProductVO returnobj = new ProductVO();
		try {
			returnobj= productDao.allProductVarients();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProductVO saveProductVarient(ProductVO obj) {
		ProductVO returnobj = new ProductVO();
		try {
			returnobj= productDao.saveProductVarient(obj) ;
			returnobj.setProductVarientList(productDao.allProductVarients().getProductVarientList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	
	
}
