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

import com.app.steedApplication.entity.BOMEntity;
import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.MachineProcessMap;
import com.app.steedApplication.entity.ProductEntity;
import com.app.steedApplication.entity.SequenceEntity;
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
			tableList = session.createQuery(" FROM BOMEntity r ").list();
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
		Session session = this.sessionFactory.openSession();
		BillOfMaterialVO returnobj=new BillOfMaterialVO();
		
		Transaction tx=session.beginTransaction();		
		try {
				
			for(BillOfMaterialVO bomObj : obj.getBomProductList() ) {
				
				
				//if(bomObj.getQty().length() > 0 && !bomObj.getQty().equalsIgnoreCase("null")) {
					
				System.out.println("-->"+bomObj.getBillOfMaterialId().signum());
				if(bomObj.getBillOfMaterialId().signum() == 0 && bomObj.getQty().length() > 0) {
					
					BOMEntity saveObj = new BOMEntity();
					
					saveObj.setMaterialId(bomObj.getProductId());
					saveObj.setProductId(obj.getProductId());
					
					saveObj.setQuantity(Float.parseFloat(bomObj.getQty()));
					
					saveObj.setCreated(new Date());
					saveObj.setUpdated(new Date());
					saveObj.setCreatedBy(obj.getCreatedBy());
					saveObj.setUpdatedBy(obj.getUpdatedBy());
					
					session.save(saveObj);
					returnobj.setValid(true);
					
				}else if(bomObj.getBillOfMaterialId().signum() != 0){
					
					BOMEntity updateObj = (BOMEntity) session.createQuery(" FROM BOMEntity r where r.billOfMaterialId="+bomObj.getBillOfMaterialId()).uniqueResult();
					updateObj.setQuantity(Float.parseFloat(bomObj.getQty()));
					
					updateObj.setUpdated(new Date());
					updateObj.setUpdatedBy(obj.getUpdatedBy());
					
					session.saveOrUpdate(updateObj);
					returnobj.setValid(true);
					
				}
					
					returnobj.setResponseMsg("BOM Details Added Successfully");
				//}
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
				categoryqry="AND (rm.is_basic=1 OR rm.is_common=1)";
			}else {
				categoryqry="AND (rm.is_premium=1 OR rm.is_common=1)";
			}
			
			tableList = session.createSQLQuery("SELECT 0 as billOfMaterialId,rm.raw_material_id AS productId,rm.material_code AS productCode,rm.raw_material_name AS productName,rm.measurement_type AS measurementType,uom.measurement_name AS measurementName,'' AS qty,(case when rm.is_basic=1 then 'Basic' when rm.is_common=1 then 'Common'  when rm.is_premium=1 then 'Premium'   ELSE ''	end) AS uomType  FROM raw_material rm,unit_of_measurement uom WHERE is_bom='Active' AND rm.units=uom.measurement_id AND rm.measurement_type=uom.measurement_type  "+categoryqry+"  AND rm.raw_material_id NOT IN (SELECT bm.material_id  FROM bill_of_material bm WHERE bm.product_id= '"+productId+"')\r\n" + 
					"   union " + 
					"  SELECT bm.bill_of_material_id as billOfMaterialId,bm.material_id AS productId,rm.material_code AS productCode,rm.raw_material_name AS productName,rm.measurement_type AS measurementType,uom.measurement_name AS measurementName,bm.quantity AS qty,(case when rm.is_basic=1 then 'Basic' when rm.is_common=1 then 'Common'  when rm.is_premium=1 then 'Premium'   ELSE ''	end) AS uomType  FROM bill_of_material bm,raw_material rm,unit_of_measurement uom WHERE bm.material_id=rm.raw_material_id AND rm.is_bom='Active' AND rm.units=uom.measurement_id AND rm.measurement_type=uom.measurement_type AND  bm.product_id= '"+productId+"'")
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
