package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.DealerDao;
import com.app.steedApplication.modules.masters.model.DealerVO;
import com.app.steedApplication.modules.masters.service.DealerService;


@Service
@Transactional
public class DealerServiceImpl implements DealerService {
	
	@Autowired
	private DealerDao dealerDao;

	
	@Override
	public DealerVO getAllDealer() {
		DealerVO returnobj = new DealerVO();
		try {
			returnobj= dealerDao.getAllDealer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}
	

	@Override
	public DealerVO finddealerbyId(int id) {
		DealerVO returnobj = new DealerVO();
		try {
			returnobj= dealerDao.finddealerbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public DealerVO deleteDealerbyId(int id) {
		DealerVO returnobj = new DealerVO();
		try {
			returnobj= dealerDao.deleteDealerbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public DealerVO saveDealer(DealerVO obj) {
		DealerVO returnobj = new DealerVO();
		try {
			returnobj= dealerDao.saveDealer(obj) ;
			returnobj.setDealerList(dealerDao.getAllDealer().getDealerList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

	
	
}
