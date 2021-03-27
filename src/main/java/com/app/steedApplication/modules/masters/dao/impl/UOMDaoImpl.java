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

import com.app.steedApplication.entity.UOMEntity;
import com.app.steedApplication.entity.UserUOMEntity;
import com.app.steedApplication.modules.masters.dao.UOMDao;
import com.app.steedApplication.modules.masters.model.UOMVO;


@Repository
public class UOMDaoImpl implements UOMDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public UOMVO getAllUOMs() {
		Session session = this.sessionFactory.openSession();
		UOMVO returnobj=new UOMVO();
		List<UOMEntity> UOMList= new ArrayList<UOMEntity>();
		try {

			UOMList = session.createQuery(" FROM UOMEntity r").list();
		//	System.out.println("UOMList------"+UOMList.size());
			returnobj.setValid(true);
			returnobj.setUOMList(UOMList);
		} catch (Exception e) {
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}	
			UOMList=null;
		}		
		return returnobj;
	}

	@Override
	public UOMVO deleteUOMbyId(int id) {
		Session session = this.sessionFactory.openSession();
		UOMVO returnobj=new UOMVO();
		Transaction tx=session.beginTransaction();
		try {

			session.createQuery(" UPDATE UOMEntity SET status='N' WHERE UOMId="+id).executeUpdate();
			tx.commit();
			returnobj.setValid(true);
		} catch (Exception e) {
			tx.rollback();
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
	public UOMVO findUOMbyId(int id) {
		Session session = this.sessionFactory.openSession();
		UOMVO returnobj=new UOMVO();
		List<UOMEntity> UOMList= new ArrayList<UOMEntity>();
		try {

			UOMList = session.createQuery(" FROM UOMEntity r where r.status='Y' and UOMId="+id).list();
			//System.out.println("userList------"+UOMList.size());
			returnobj.setValid(true);
			returnobj.setUOMList(UOMList);
		} catch (Exception e) {
			e.printStackTrace();
			returnobj.setValid(false);
			returnobj.setResponseMsg(e.getMessage());
		} finally {
			if(session != null){
				session.close();
				session = null;
			}
			UOMList=null;
		}		
		return returnobj;
	}

	@Override
	public UOMVO saveUOM(UOMVO obj) {
		Session session = this.sessionFactory.openSession();
		UOMVO returnobj=new UOMVO();
		List<UOMEntity> UOMList= new ArrayList<UOMEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			UOMEntity UOMObj=obj.getUOMObj();
			if(UOMObj.getUOMId() == 0) { // New Row
				UOMList = session.createQuery(" FROM UOMEntity AS u WHERE u.UOMName = '"+UOMObj.getUOMName()+"'").list();
				System.out.println("IF userList------"+UOMList.size());
				if(UOMList.size() == 0) {
					
					
					UOMObj.setCreated(new Date());
					UOMObj.setUpdated(new Date());
					session.save(UOMObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("UOM Name Already Exists");
				}
			}else { // update
				UOMList = session.createQuery(" FROM UOMEntity AS u WHERE u.UOMName = '"+UOMObj.getUOMName()+"' AND UOMId!="+UOMObj.getUOMId()).list();
				System.out.println("ELSE UOMList------"+UOMList.size());
				if(UOMList.size() == 0) {
					
					
					UOMObj.setCreated(new Date());
					UOMObj.setUpdated(new Date());
					session.saveOrUpdate(UOMObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("UOM Name Already Exists");
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
