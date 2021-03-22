package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.ProcessFlowVO;

public interface ProcessFlowDao {

	ProcessFlowVO getAllProcessFlows();

	ProcessFlowVO findProcessFlowbyId(int id);

	ProcessFlowVO deleteProcessFlowbyId(int id);

	ProcessFlowVO saveProcessFlow(ProcessFlowVO obj);

}
