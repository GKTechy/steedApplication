package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.BOMEntity;
import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.modules.masters.dao.BillOfMaterialDao;
import com.app.steedApplication.modules.masters.model.BillOfMaterialVO;
import com.app.steedApplication.modules.masters.model.DealerVO;

@Repository
public class BillOfMaterialDaoImpl implements BillOfMaterialDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());

	
	@Override
	public BillOfMaterialVO getAllBillOfMaterial() {
		Session session = this.sessionFactory.openSession();
		BillOfMaterialVO returnobj=new BillOfMaterialVO();
		List<BOMEntity> tableList= new ArrayList<BOMEntity>();
		try {
			tableList = session.createQuery(" FROM BOMEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setBOMList(tableList);
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
	public BillOfMaterialVO findBillOfMaterialbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillOfMaterialVO deleteBillOfMaterialbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillOfMaterialVO saveBillOfMaterial(BillOfMaterialVO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillOfMaterialVO productBoms(int productId) {
		Session session = this.sessionFactory.openSession();
		BillOfMaterialVO returnobj=new BillOfMaterialVO();
		List<BOMEntity> tableList= new ArrayList<BOMEntity>();
		try {
			tableList = session.createQuery(" FROM BOMEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setBOMList(tableList);
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
