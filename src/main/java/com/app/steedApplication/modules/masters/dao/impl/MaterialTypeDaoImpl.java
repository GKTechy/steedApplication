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
import com.app.steedApplication.entity.UserRoleEntity;
import com.app.steedApplication.modules.masters.dao.MaterialTypeDao;
import com.app.steedApplication.modules.masters.model.MaterialTypeVO;
import com.app.steedApplication.modules.masters.model.RoleVO;


@Repository
public class MaterialTypeDaoImpl implements MaterialTypeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Override
	public MaterialTypeVO getAllMaterialTypes() {
		Session session = this.sessionFactory.openSession();
		MaterialTypeVO returnobj=new MaterialTypeVO();
		List<MaterialTypeEntity> tableList= new ArrayList<MaterialTypeEntity>();
		try {

			tableList = session.createQuery(" FROM MaterialTypeEntity r where r.isActive='Active'").list();
		//	System.out.println("roleList------"+roleList.size());
			returnobj.setValid(true);
			returnobj.setMaterialTypeList(tableList);
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
	public MaterialTypeVO findMaterialTypebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaterialTypeVO deleteMaterialTypebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaterialTypeVO saveMaterialType(MaterialTypeVO obj) {
		Session session = this.sessionFactory.openSession();
		MaterialTypeVO returnobj=new MaterialTypeVO();
		List<MaterialTypeEntity> mlist= new ArrayList<MaterialTypeEntity>();
		Transaction tx=session.beginTransaction();		
		try {
			MaterialTypeEntity robj=obj.getMaterialTypeObj();
			if(robj.getMaterialTypeId() == 0) { // New Row
				mlist = session.createQuery(" FROM MaterialTypeEntity AS u WHERE u.materialTypeName = '"+robj.getMaterialTypeName()+"'").list();
				//System.out.println("IF userList------"+mlist.size());
				if(mlist.size() == 0) {
					
					//System.out.println("active-->"+robj.getIsActive());
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.save(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Material Type Name Already Exists");
				}
			}else { // update
				mlist = session.createQuery(" FROM MaterialTypeEntity AS u WHERE u.materialTypeName = '"+robj.getMaterialTypeName()+"' AND materialTypeId!="+robj.getMaterialTypeId()).list();
				//System.out.println("ELSE userList------"+mlist.size());
				if(mlist.size() == 0) {
					robj.setCreated(new Date());
					robj.setUpdated(new Date());
					session.saveOrUpdate(robj);
					returnobj.setValid(true);
				} else {
					returnobj.setValid(false);
					returnobj.setResponseMsg("Material Type Name Already Exists");
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
