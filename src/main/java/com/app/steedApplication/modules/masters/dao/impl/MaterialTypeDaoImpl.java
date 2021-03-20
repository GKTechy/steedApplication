package com.app.steedApplication.modules.masters.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.steedApplication.entity.MaterialTypeEntity;
import com.app.steedApplication.modules.masters.dao.MaterialTypeDao;
import com.app.steedApplication.modules.masters.model.MaterialTypeVO;


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

			tableList = session.createQuery(" FROM MaterialTypeEntity r where r.status='Y'").list();
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
		// TODO Auto-generated method stub
		return null;
	}

}
