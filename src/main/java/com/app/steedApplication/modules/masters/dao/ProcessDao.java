package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.ProcessVO;

public interface ProcessDao {

	ProcessVO getAllProcesss();

	ProcessVO findProcessbyId(int id);

	ProcessVO deleteProcessbyId(int id);

	ProcessVO saveProcess(ProcessVO obj);

}
