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

import com.app.steedApplication.entity.RawMaterialEntity;
import com.app.steedApplication.modules.masters.dao.RawMaterialDao;
import com.app.steedApplication.modules.masters.model.RawMaterialVO;

@Repository
public class RawMaterialDaoImpl implements RawMaterialDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public RawMaterialVO getAllRawMaterials() {
		Session session = this.sessionFactory.openSession();
		RawMaterialVO returnobj=new RawMaterialVO();
		List<RawMaterialEntity> tableList= new ArrayList<RawMaterialEntity>();
		try {

			tableList = session.createQuery(" FROM RawMaterialEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setRawMaterialList(tableList);
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
	public RawMaterialVO findRawMaterialbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RawMaterialVO deleteRawMaterialbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RawMaterialVO saveRawMaterial(RawMaterialVO obj) {
		Session session = this.sessionFactory.openSession();
		RawMaterialVO returnobj=new RawMaterialVO();
		List<RawMaterialEntity> mlist= new ArrayList<RawMaterialEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			RawMaterialEntity robj=obj.getRawMaterialObj();
			if(robj.getRawMaterialId() == 0) { // New Row
				mlist = session.createQuery(" FROM RawMaterialEntity AS u WHERE u.rawMaterialName = '"+robj.getRawMaterialName()+"' AND u.rawMaterialId = '"+robj.getRawMaterialId()+"'").list();
				//System.out.println("IF userList------"+mlist.size());
				if(mlist.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.save(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Raw Material Already Exists");
				}
			}else { // update
				mlist = session.createQuery(" FROM RawMaterialEntity AS u WHERE u.rawMaterialName = '"+robj.getRawMaterialName()+"'  AND rawMaterialId!="+robj.getRawMaterialId()).list();
				//System.out.println("ELSE userList------"+mlist.size());
				if(mlist.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Raw Material Already Exists");
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
