package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.ProcessFlowEntity;
import com.app.steedApplication.entity.ProductEntity;
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
			tableList = session.createSQLQuery(" SELECT pf.process_flow_id AS processFlowId,pf.product_id AS productId,CONCAT(p.order_code,'_',p.colors,'_',p.product_name) as productName,pf.process_id AS processId, pr.process_name AS processName,pf.cycle_time as cycleTime,pf.operation_no as operationNo FROM process_flow pf,product p, process pr WHERE pf.product_id=p.product_id AND pr.process_id=pf.process_id")
					.setResultTransformer(Transformers.aliasToBean(ProcessFlowEntity.class)).list();
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
		Session session = this.sessionFactory.openSession();
		ProcessFlowVO returnobj=new ProcessFlowVO();
		List<ProcessFlowEntity> mlist= new ArrayList<ProcessFlowEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			ProcessFlowEntity robj=obj.getProcessFlowObj();
			if(robj.getProcessFlowId() == 0) { // New Row
				mlist = session.createQuery(" FROM ProcessFlowEntity AS u WHERE u.productId = '"+robj.getProductId()+"' AND u.processId = '"+robj.getProcessId()+"'").list();
				//System.out.println("IF userList------"+mlist.size());
				if(mlist.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.save(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Process Flow Already Exists");
				}
			}else { // update
				mlist = session.createQuery(" FROM ProcessFlowEntity AS u WHERE u.productId = '"+robj.getProductId()+"'  AND processId="+robj.getProcessId()+"+ AND processFlowId!="+robj.getProcessFlowId()).list();
				//System.out.println("ELSE userList------"+mlist.size());
				if(mlist.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Process Flow Already Exists");
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
