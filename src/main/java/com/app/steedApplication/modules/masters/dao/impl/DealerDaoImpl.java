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

import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.MachineProcessMap;
import com.app.steedApplication.modules.masters.dao.DealerDao;
import com.app.steedApplication.modules.masters.model.DealerVO;
import com.app.steedApplication.modules.masters.model.MachineVO;

@Repository
public class DealerDaoImpl implements DealerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	
	@Override
	public DealerVO getAllDealer() {
		Session session = this.sessionFactory.openSession();
		DealerVO returnobj=new DealerVO();
		List<DealerEntity> tableList= new ArrayList<DealerEntity>();
		try {
			tableList = session.createQuery(" FROM DealerEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setDealerList(tableList);
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
	public DealerVO finddealerbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DealerVO deleteDealerbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DealerVO saveDealer(DealerVO obj) {
		Session session = this.sessionFactory.openSession();
		DealerVO returnobj=new DealerVO();
		List<DealerEntity> mlist= new ArrayList<DealerEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			DealerEntity robj=obj.getDealerObj();
			if(robj.getDealerId() == 0) { // New Row
				mlist = session.createQuery(" FROM DealerEntity AS u WHERE u.dealerName = '"+robj.getDealerName()+"' AND u.dealerId = '"+robj.getDealerId()+"'").list();
				//System.out.println("IF userList------"+mlist.size());
				if(mlist.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.save(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Dealer Name Already Exists");
				}
			}else { // update
				mlist = session.createQuery(" FROM DealerEntity AS u WHERE u.dealerName = '"+robj.getDealerName()+"'  AND dealerId!="+robj.getDealerId()).list();
				//System.out.println("ELSE userList------"+mlist.size());
				if(mlist.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Dealer Name Already Exists");
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
