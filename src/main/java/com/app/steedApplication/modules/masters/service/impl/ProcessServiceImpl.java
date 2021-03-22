package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.ProcessDao;
import com.app.steedApplication.modules.masters.model.ProcessVO;

@Service
@Transactional
public class ProcessServiceImpl implements ProcessDao{


	@Autowired
	private ProcessDao processDao;

	
	@Override
	public ProcessVO getAllProcesss() {
		ProcessVO returnobj = new ProcessVO();
		try {
			returnobj= processDao.getAllProcesss();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProcessVO findProcessbyId(int id) {
		ProcessVO returnobj = new ProcessVO();
		try {
			returnobj= processDao.findProcessbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProcessVO deleteProcessbyId(int id) {
		ProcessVO returnobj = new ProcessVO();
		try {
			returnobj= processDao.deleteProcessbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProcessVO saveProcess(ProcessVO obj) {
		ProcessVO returnobj = new ProcessVO();
		try {
			returnobj= processDao.saveProcess(obj) ;
			returnobj.setProcessList(processDao.getAllProcesss().getProcessList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


}
