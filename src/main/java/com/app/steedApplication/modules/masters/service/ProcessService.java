package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.ProcessVO;

public interface ProcessService {

	ProcessVO getAllProcesss();

	ProcessVO findProcessbyId(int id);

	ProcessVO deleteProcessbyId(int id);

	ProcessVO saveProcess(ProcessVO obj);

}
