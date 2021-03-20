package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.MaterialTypeVO;

public interface MaterialTypeDao {

	MaterialTypeVO getAllMaterialTypes();

	MaterialTypeVO findMaterialTypebyId(int id);

	MaterialTypeVO deleteMaterialTypebyId(int id);

	MaterialTypeVO saveMaterialType(MaterialTypeVO obj);

}
