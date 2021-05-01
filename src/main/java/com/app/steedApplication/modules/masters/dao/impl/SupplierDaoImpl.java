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

import com.app.steedApplication.entity.SequenceEntity;
import com.app.steedApplication.entity.SupplierEntity;
import com.app.steedApplication.modules.masters.dao.SupplierDao;
import com.app.steedApplication.modules.masters.model.SupplierVO;

@Repository
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	
	@Override
	public SupplierVO getAllSupplier() {
		Session session = this.sessionFactory.openSession();
		SupplierVO returnobj=new SupplierVO();
		List<SupplierEntity> tableList= new ArrayList<SupplierEntity>();
		SequenceEntity sObj=new SequenceEntity();
		try {
			tableList = session.createQuery(" FROM SupplierEntity r where r.isActive='Active'").list();
			sObj = (SequenceEntity) session.createQuery(" FROM SequenceEntity r where r.value='SLR'").uniqueResult();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setSupplierList(tableList);
			returnobj.setSObj(sObj);
			
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
	public SupplierVO findSupplierbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierVO deleteSupplierbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierVO saveSupplier(SupplierVO obj) {
		Session session = this.sessionFactory.openSession();
		SupplierVO returnobj=new SupplierVO();
		List<SupplierEntity> mlist= new ArrayList<SupplierEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			SupplierEntity robj=obj.getSupplierObj();
			if(robj.getSupplierId() == 0) { // New Row
				mlist = session.createQuery(" FROM SupplierEntity AS u WHERE u.supplierName = '"+robj.getSupplierName()+"' AND u.supplierId = '"+robj.getSupplierId()+"'").list();
				//System.out.println("IF userList------"+mlist.size());
				if(mlist.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.save(robj);
					
					SequenceEntity seqobj=new SequenceEntity();
					seqobj = (SequenceEntity) session.createQuery(" FROM SequenceEntity AS u WHERE u.value = 'SLR' ").uniqueResult();
					
					int cNumber=Integer.parseInt(seqobj.getCurrentNext())+1;
					String input = "00000"+cNumber ;//000105
					String nextValue = input.substring(input.length() - 5);
					
					System.out.println("nextValue:"+nextValue);
					seqobj.setCurrentNext(nextValue);
					session.saveOrUpdate(seqobj);
					
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Supplier Name Already Exists");
				}
			}else { // update
				mlist = session.createQuery(" FROM SupplierEntity AS u WHERE u.supplierName = '"+robj.getSupplierName()+"'  AND supplierId!="+robj.getSupplierId()).list();
				//System.out.println("ELSE userList------"+mlist.size());
				if(mlist.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Supplier Name Already Exists");
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
