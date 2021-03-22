package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.ProcessEntity;
import com.app.steedApplication.entity.UserRoleEntity;
import com.app.steedApplication.modules.masters.dao.ProcessDao;
import com.app.steedApplication.modules.masters.model.ProcessVO;
import com.app.steedApplication.modules.masters.model.RoleVO;

@Repository
public class ProcessDaoImpl implements ProcessDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	@Override
	public ProcessVO getAllProcesss() {
		Session session = this.sessionFactory.openSession();
		ProcessVO returnobj=new ProcessVO();
		List<ProcessEntity> tableList= new ArrayList<ProcessEntity>();
		try {

			tableList = session.createQuery(" FROM ProcessEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setProcessList(tableList);
		} catch (Exception e) {
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
			tableList=null;
		}		
		return returnobj;
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
		Session session = this.sessionFactory.openSession();
		ProcessVO returnobj=new ProcessVO();
		List<ProcessEntity> roleList= new ArrayList<ProcessEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			ProcessEntity saveObj=obj.getProcessObj();
			if(saveObj.getProcessId() == 0) { // New Row
				roleList = session.createQuery(" FROM ProcessEntity AS u WHERE u.processName = '"+saveObj.getProcessName()+"'").list();
				System.out.println("IF list------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					saveObj.setCreated(new Date());
					saveObj.setUpdated(new Date());
					session.save(saveObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Process Name Already Exists");
				}
			}else { // update
				roleList = session.createQuery(" FROM ProcessEntity AS u WHERE u.processName = '"+saveObj.getProcessName()+"' AND processId!="+saveObj.getProcessId()).list();
				System.out.println("ELSE list------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					saveObj.setCreated(new Date());
					saveObj.setUpdated(new Date());
					session.saveOrUpdate(saveObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Process Name Already Exists");
				}
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
			logger.info(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
	
		}		
		return returnobj;
	}

}
