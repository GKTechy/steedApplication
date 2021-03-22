package com.app.steedApplication.modules.masters.dao.impl;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.modules.masters.dao.OrderCodeDao;
import com.app.steedApplication.modules.masters.model.OrderCodeVO;


@Repository
public class OrderCodeDaoImpl implements OrderCodeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	@Override
	public OrderCodeVO getAllOrderCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderCodeVO findOrderCodebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderCodeVO deleteOrderCodebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderCodeVO saveOrderCode(OrderCodeVO obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
