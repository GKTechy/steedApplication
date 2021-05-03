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

import com.app.steedApplication.entity.DealerOrderEntity;
import com.app.steedApplication.entity.DealerOrderProductsEntity;
import com.app.steedApplication.entity.SequenceEntity;
import com.app.steedApplication.modules.masters.dao.DealerOrderDao;
import com.app.steedApplication.modules.masters.model.BillOfMaterialVO;
import com.app.steedApplication.modules.masters.model.DealerOrderVO;


@Repository
public class DealerOrderDaoImpl implements DealerOrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public DealerOrderVO getAllDealerOrder() {
		Session session = this.sessionFactory.openSession();
		DealerOrderVO returnobj=new DealerOrderVO();
		List<DealerOrderEntity> tableList= new ArrayList<DealerOrderEntity>();
		List<DealerOrderProductsEntity> productList= new ArrayList<DealerOrderProductsEntity>();
		SequenceEntity sObj=new SequenceEntity();
		try {
			tableList = session.createSQLQuery(" SELECT o.dealer_order_id AS dealerOrderId,o.order_no AS orderNo,o.order_for AS orderFor,o.order_date AS orderDate,o.reference AS reference,o.subtotal AS subtotal,o.tax_total AS taxTotal,o.total AS total, o.dealer_id AS dealerId,d.dealer_name AS dealerName, d.dealer_contact_person AS dealerContactPerson FROM dealer_order o,dealer d WHERE d.dealer_id=o.dealer_id")
					.setResultTransformer(Transformers.aliasToBean(DealerOrderEntity.class)).list();
		//	productList = session.createQuery(" FROM DealerOrderProductsEntity r").list();
		//	sObj = (SequenceEntity) session.createQuery(" FROM SequenceEntity r where r.value='DLR'").uniqueResult();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setDealerOrderList(tableList);
			returnobj.setDealerOrderProductsList(productList);
			//returnobj.setSObj(sObj);
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
	public DealerOrderVO saveDealerOrder(DealerOrderVO obj) {
		Session session = this.sessionFactory.openSession();
		DealerOrderVO returnobj=new DealerOrderVO();
		List<DealerOrderEntity> tableList= new ArrayList<DealerOrderEntity>();
		SequenceEntity sObj=new SequenceEntity();
		
		Transaction tx=session.beginTransaction();		
		
		try {
			
			if(obj.getDealerOrderObj().getDealerOrderId() == 0) {
				DealerOrderEntity headerobj=obj.getDealerOrderObj();
				
				
				headerobj.setCreated(new Date());
				headerobj.setUpdated(new Date());
				headerobj.setCreatedBy(obj.getCreatedBy());
				headerobj.setUpdatedBy(obj.getUpdatedBy());
				
				session.save(headerobj);
				
				for(DealerOrderProductsEntity lineobj: obj.getDealerOrderProductsList()) {
				
					lineobj.setDealerOrderId(headerobj.getDealerOrderId());
					lineobj.setCreated(new Date());
					lineobj.setUpdated(new Date());
					lineobj.setCreatedBy(obj.getCreatedBy());
					lineobj.setUpdatedBy(obj.getUpdatedBy());
					session.save(lineobj);
				}
				
			}
			System.out.println("---obj-->"+obj.toString());
			
			
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
	public DealerOrderVO findDealerOrderbyId(int id) {
		Session session = this.sessionFactory.openSession();
		DealerOrderVO returnobj=new DealerOrderVO();
		List<DealerOrderProductsEntity> productList= new ArrayList<DealerOrderProductsEntity>();
		SequenceEntity sObj=new SequenceEntity();
		try {
			productList = session.createQuery(" FROM DealerOrderProductsEntity r where r.dealerOrderId="+id).list();
		//	sObj = (SequenceEntity) session.createQuery(" FROM SequenceEntity r where r.value='DLR'").uniqueResult();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setDealerOrderProductsList(productList);
			//returnobj.setSObj(sObj);
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

}
