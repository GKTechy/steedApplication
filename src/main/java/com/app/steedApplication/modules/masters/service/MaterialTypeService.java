package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.MaterialTypeVO;

public interface MaterialTypeService {

	MaterialTypeVO getAllMaterialTypes();

	MaterialTypeVO findMaterialTypebyId(int id);

	MaterialTypeVO deleteMaterialTypebyId(int id);

	MaterialTypeVO saveMaterialType(MaterialTypeVO obj);

}
