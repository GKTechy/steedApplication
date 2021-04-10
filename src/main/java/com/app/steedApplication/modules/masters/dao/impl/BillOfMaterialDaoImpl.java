package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.BOMEntity;
import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.MachineProcessMap;
import com.app.steedApplication.entity.ProductEntity;
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
		List<BillOfMaterialVO> tableList= new ArrayList<BillOfMaterialVO>();
		ProductEntity productObj=new ProductEntity();
		try {
			productObj=(ProductEntity) session.createQuery(" FROM ProductEntity AS u WHERE u.productId = '"+productId+"'").uniqueResult();
			
			String categoryqry="";
			
			if(productObj.getCategory().equalsIgnoreCase("basic")) {
				categoryqry="AND rm.is_basic=1 OR rm.is_common=1";
			}else {
				categoryqry="AND rm.is_premium=1 OR rm.is_common=1";
			}
			
			tableList = session.createSQLQuery("SELECT rm.raw_material_id AS productId,rm.raw_material_name AS productName,rm.measurement_type AS measurementType,'' AS qty  FROM raw_material rm WHERE is_bom='Active' "+categoryqry+"  AND rm.raw_material_id NOT IN (SELECT bm.bill_of_material_item_id  FROM bill_of_material bm WHERE bm.product_id= '"+productId+"')\r\n" + 
					"   union " + 
					"  SELECT bm.bill_of_material_item_id AS productId,rm.raw_material_name AS productName,rm.measurement_type AS measurementType,bm.bill_of_material_item_quantity AS qty  FROM bill_of_material bm,raw_material rm WHERE bm.bill_of_material_item_id=rm.raw_material_id AND rm.is_bom='Active'  AND rm.raw_material_id NOT IN ( SELECT bm.bill_of_material_item_id  FROM bill_of_material bm WHERE bm.product_id= '"+productId+"')")
					.setResultTransformer(Transformers.aliasToBean(BillOfMaterialVO.class)).list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setBomProductList(tableList);
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
