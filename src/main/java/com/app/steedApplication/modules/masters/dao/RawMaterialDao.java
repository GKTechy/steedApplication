package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.RawMaterialVO;

public interface RawMaterialDao {

	RawMaterialVO getAllRawMaterials();

	RawMaterialVO findRawMaterialbyId(int id);

	RawMaterialVO deleteRawMaterialbyId(int id);

	RawMaterialVO saveRawMaterial(RawMaterialVO obj);

}
