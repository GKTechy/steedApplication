package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.OrderCodeDao;
import com.app.steedApplication.modules.masters.model.OrderCodeVO;
import com.app.steedApplication.modules.masters.service.OrderCodeService;

@Service
@Transactional
public class OrderCodeServiceImpl implements OrderCodeService {

	@Autowired
	private OrderCodeDao orderCodeDao;

	
	@Override
	public OrderCodeVO getAllOrderCodes() {
		OrderCodeVO returnobj = new OrderCodeVO();
		try {
			returnobj= orderCodeDao.getAllOrderCodes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public OrderCodeVO findOrderCodebyId(int id) {
		OrderCodeVO returnobj = new OrderCodeVO();
		try {
			returnobj= orderCodeDao.findOrderCodebyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public OrderCodeVO deleteOrderCodebyId(int id) {
		OrderCodeVO returnobj = new OrderCodeVO();
		try {
			returnobj= orderCodeDao.deleteOrderCodebyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public OrderCodeVO saveOrderCode(OrderCodeVO obj) {
		OrderCodeVO returnobj = new OrderCodeVO();
		try {
			returnobj= orderCodeDao.saveOrderCode(obj) ;
			returnobj.setOrderCodeList(orderCodeDao.getAllOrderCodes().getOrderCodeList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

}
