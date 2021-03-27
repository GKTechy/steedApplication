package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.UOMVO;

public interface UOMService {

	UOMVO getAllUOMs();

	UOMVO findUOMbyId(int id);

	UOMVO deleteUOMbyId(int id);

	UOMVO saveUOM(UOMVO obj);
	

}
