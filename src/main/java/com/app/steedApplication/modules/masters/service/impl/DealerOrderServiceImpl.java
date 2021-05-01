package com.app.steedApplication.modules.masters.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.steedApplication.modules.masters.dao.DealerDao;
import com.app.steedApplication.modules.masters.dao.DealerOrderDao;
import com.app.steedApplication.modules.masters.dao.ProductDao;
import com.app.steedApplication.modules.masters.model.DealerOrderVO;
import com.app.steedApplication.modules.masters.service.DealerOrderService;


@Service
@Transactional
public class DealerOrderServiceImpl implements DealerOrderService {
	
	@Autowired
	private DealerDao dealerDao;

	
	@Autowired
	private DealerOrderDao dealerOrderDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public DealerOrderVO getAllDealerOrder() {
		DealerOrderVO returnobj = new DealerOrderVO();
		try {
			returnobj= dealerOrderDao.getAllDealerOrder();
			returnobj.setDealerList(dealerDao.getAllDealer().getDealerList());
			returnobj.setProductList(productDao.getAllProducts().getProductList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	@Override
	public DealerOrderVO findDealerOrderbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DealerOrderVO deleteDealerOrderbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DealerOrderVO saveDealerOrder(DealerOrderVO obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
