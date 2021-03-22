package com.app.steedApplication.modules.masters.dao.impl;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.modules.masters.dao.ProductDao;
import com.app.steedApplication.modules.masters.model.ProductVO;

@Repository
public class ProductDaoImpl implements ProductDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	@Override
	public ProductVO getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVO findProductbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVO deleteProductbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVO saveProduct(ProductVO obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
