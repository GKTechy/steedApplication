package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.MaterialTypeDao;
import com.app.steedApplication.modules.masters.model.MaterialTypeVO;
import com.app.steedApplication.modules.masters.service.MaterialTypeService;

@Service
@Transactional
public class MaterialTypeServiceImpl implements MaterialTypeService {

	@Autowired
	private MaterialTypeDao materialTypeDao;

	
	@Override
	public MaterialTypeVO getAllMaterialTypes() {
		MaterialTypeVO returnobj = new MaterialTypeVO();
		try {
			returnobj= materialTypeDao.getAllMaterialTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public MaterialTypeVO findMaterialTypebyId(int id) {
		MaterialTypeVO returnobj = new MaterialTypeVO();
		try {
			returnobj= materialTypeDao.findMaterialTypebyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public MaterialTypeVO deleteMaterialTypebyId(int id) {
		MaterialTypeVO returnobj = new MaterialTypeVO();
		try {
			returnobj= materialTypeDao.deleteMaterialTypebyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public MaterialTypeVO saveMaterialType(MaterialTypeVO obj) {
		MaterialTypeVO returnobj = new MaterialTypeVO();
		try {
			returnobj= materialTypeDao.saveMaterialType(obj) ;
			returnobj.setMaterialTypeList(materialTypeDao.getAllMaterialTypes().getMaterialTypeList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


}
