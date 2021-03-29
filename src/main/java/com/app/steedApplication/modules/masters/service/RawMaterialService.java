package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.RawMaterialVO;

public interface RawMaterialService {

	RawMaterialVO getAllRawMaterials();

	RawMaterialVO findRawMaterialbyId(int id);

	RawMaterialVO deleteRawMaterialbyId(int id);

	RawMaterialVO saveRawMaterial(RawMaterialVO obj);


}
