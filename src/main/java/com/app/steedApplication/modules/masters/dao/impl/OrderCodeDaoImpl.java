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

import com.app.steedApplication.entity.OrderCodeEntity;
import com.app.steedApplication.entity.UserRoleEntity;
import com.app.steedApplication.modules.masters.dao.OrderCodeDao;
import com.app.steedApplication.modules.masters.model.OrderCodeVO;


@Repository
public class OrderCodeDaoImpl implements OrderCodeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	@Override
	public OrderCodeVO getAllOrderCodes() {
		Session session = this.sessionFactory.openSession();
		OrderCodeVO returnobj=new OrderCodeVO();
		List<OrderCodeEntity> tableList= new ArrayList<OrderCodeEntity>();
		try {

			tableList = session.createQuery(" FROM OrderCodeEntity r").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setOrderCodeList(tableList);
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
	public OrderCodeVO findOrderCodebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderCodeVO deleteOrderCodebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderCodeVO saveOrderCode(OrderCodeVO obj) {
		Session session = this.sessionFactory.openSession();
		OrderCodeVO returnobj=new OrderCodeVO();
		List<UserRoleEntity> roleList= new ArrayList<UserRoleEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			OrderCodeEntity saveObj=obj.getOrderCodeObj();
			if(saveObj.getOrderCodeId() == 0) { // New Row
				roleList = session.createQuery(" FROM OrderCodeEntity AS u WHERE u.orderCode = '"+saveObj.getOrderCode()+"' AND u.colorCode = '"+saveObj.getColorCode()+"'").list();
				System.out.println("IF ------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					saveObj.setCreated(new Date());
					saveObj.setUpdated(new Date());
					session.save(saveObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Order Code Details Already Exists");
				}
			}else { // update
				roleList = session.createQuery(" FROM OrderCodeEntity AS u WHERE u.orderCode = '"+saveObj.getOrderCode()+"' AND u.colorCode = '"+saveObj.getColorCode()+"' AND orderCodeId!="+saveObj.getOrderCodeId()).list();
				System.out.println("ELSE ------"+roleList.size());
				if(roleList.size() == 0) {
					
					
					saveObj.setCreated(new Date());
					saveObj.setUpdated(new Date());
					session.saveOrUpdate(saveObj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Order Code Details Already Exists");
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
