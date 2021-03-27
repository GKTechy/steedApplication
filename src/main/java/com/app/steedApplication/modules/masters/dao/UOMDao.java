package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.UOMVO;

public interface UOMDao {

	UOMVO getAllUOMs();

	UOMVO findUOMbyId(int id);

	UOMVO deleteUOMbyId(int id);

	UOMVO saveUOM(UOMVO obj);

}
