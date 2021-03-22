package com.app.steedApplication.modules.masters.dao.impl;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.modules.masters.dao.ProcessDao;
import com.app.steedApplication.modules.masters.model.ProcessVO;

@Repository
public class ProcessDaoImpl implements ProcessDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	@Override
	public ProcessVO getAllProcesss() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessVO findProcessbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessVO deleteProcessbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessVO saveProcess(ProcessVO obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
