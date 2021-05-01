package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.DealerOrderEntity;
import com.app.steedApplication.entity.SequenceEntity;
import com.app.steedApplication.modules.masters.dao.DealerOrderDao;
import com.app.steedApplication.modules.masters.model.DealerOrderVO;
import com.app.steedApplication.modules.masters.model.DealerVO;


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
		SequenceEntity sObj=new SequenceEntity();
		try {
			tableList = session.createQuery(" FROM DealerOrderEntity r").list();
		//	sObj = (SequenceEntity) session.createQuery(" FROM SequenceEntity r where r.value='DLR'").uniqueResult();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setDealerOrderList(tableList);
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
