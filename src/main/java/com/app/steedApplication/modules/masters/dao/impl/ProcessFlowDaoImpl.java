package com.app.steedApplication.modules.masters.dao.impl;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.modules.masters.dao.ProcessFlowDao;
import com.app.steedApplication.modules.masters.model.ProcessFlowVO;


@Repository
public class ProcessFlowDaoImpl implements ProcessFlowDao {


	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	
	@Override
	public ProcessFlowVO getAllProcessFlows() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessFlowVO findProcessFlowbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessFlowVO deleteProcessFlowbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessFlowVO saveProcessFlow(ProcessFlowVO obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
