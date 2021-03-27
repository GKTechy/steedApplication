package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.UOMDao;
import com.app.steedApplication.modules.masters.model.UOMVO;
import com.app.steedApplication.modules.masters.service.UOMService;

@Service
@Transactional
public class UOMServiceImpl implements UOMService {
	
	@Autowired
	private UOMDao UOMDao;

	
	@Override
	public UOMVO getAllUOMs() {
		UOMVO returnobj = new UOMVO();
		try {
			returnobj= UOMDao.getAllUOMs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public UOMVO findUOMbyId(int id) {
		UOMVO returnobj = new UOMVO();
		try {
			returnobj= UOMDao.findUOMbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public UOMVO deleteUOMbyId(int id) {
		UOMVO returnobj = new UOMVO();
		try {
			returnobj= UOMDao.deleteUOMbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public UOMVO saveUOM(UOMVO obj) {
		UOMVO returnobj = new UOMVO();
		try {
			returnobj= UOMDao.saveUOM(obj) ;
			returnobj.setUOMList(UOMDao.getAllUOMs().getUOMList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

}
