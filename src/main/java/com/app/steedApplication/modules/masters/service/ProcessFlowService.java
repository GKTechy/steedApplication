package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.ProcessFlowVO;

public interface ProcessFlowService {


	ProcessFlowVO findProcessFlowbyId(int id);

	ProcessFlowVO saveProcessFlow(ProcessFlowVO obj);

	ProcessFlowVO deleteProcessFlowbyId(int id);

	ProcessFlowVO getAllProcessFlows();

}
