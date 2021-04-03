package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.ProcessFlowEntity;
import com.app.steedApplication.modules.masters.dao.ProcessFlowDao;
import com.app.steedApplication.modules.masters.model.DealerVO;
import com.app.steedApplication.modules.masters.model.ProcessFlowVO;


@Repository
public class ProcessFlowDaoImpl implements ProcessFlowDao {


	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	
	@Override
	public ProcessFlowVO getAllProcessFlows() {
		Session session = this.sessionFactory.openSession();
		ProcessFlowVO returnobj=new ProcessFlowVO();
		List<ProcessFlowEntity> tableList= new ArrayList<ProcessFlowEntity>();
		try {
			tableList = session.createQuery(" FROM ProcessFlowEntity r ").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setProcessFlowList(tableList);
		} catch (Exception e) {
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}			
		}		
		return returnobj;
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
