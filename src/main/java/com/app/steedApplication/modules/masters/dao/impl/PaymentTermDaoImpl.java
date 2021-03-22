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

import com.app.steedApplication.entity.MaterialTypeEntity;
import com.app.steedApplication.entity.PaymentTermsEntity;
import com.app.steedApplication.modules.masters.dao.PaymentTermDao;
import com.app.steedApplication.modules.masters.model.MaterialTypeVO;
import com.app.steedApplication.modules.masters.model.PaymentTermVO;


@Repository
public class PaymentTermDaoImpl implements PaymentTermDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	@Override
	public PaymentTermVO getAllPaymentTerms() {
		Session session = this.sessionFactory.openSession();
		PaymentTermVO returnobj=new PaymentTermVO();
		List<PaymentTermsEntity> tableList= new ArrayList<PaymentTermsEntity>();
		try {

			tableList = session.createQuery(" FROM PaymentTermsEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setPaymentTermList(tableList);
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
	public PaymentTermVO findPaymentTermbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentTermVO deletePaymentTermbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentTermVO savePaymentTerm(PaymentTermVO obj) {

		Session session = this.sessionFactory.openSession();
		PaymentTermVO returnobj=new PaymentTermVO();
		List<PaymentTermsEntity> mlist= new ArrayList<PaymentTermsEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			PaymentTermsEntity robj=obj.getPaymentTermObj();
			if(robj.getPaymentTermsId() == 0) { // New Row
				mlist = session.createQuery(" FROM PaymentTermsEntity AS u WHERE u.description = '"+robj.getDescription()+"'").list();
				System.out.println("IF userList------"+mlist.size());
				if(mlist.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.save(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Payment Term Already Exists");
				}
			}else { // update
				mlist = session.createQuery(" FROM PaymentTermsEntity AS u WHERE u.description = '"+robj.getDescription()+"' AND paymentTermsId!="+robj.getPaymentTermsId()).list();
				System.out.println("ELSE userList------"+mlist.size());
				if(mlist.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Payment Term Already Exists");
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
