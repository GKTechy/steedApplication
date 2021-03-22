package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.ProcessFlowDao;
import com.app.steedApplication.modules.masters.model.ProcessFlowVO;
import com.app.steedApplication.modules.masters.service.ProcessFlowService;

@Service
@Transactional
public class ProcessFlowServiceImpl implements ProcessFlowService {

	@Autowired
	private ProcessFlowDao processFlowDao;

	
	@Override
	public ProcessFlowVO getAllProcessFlows() {
		ProcessFlowVO returnobj = new ProcessFlowVO();
		try {
			returnobj= processFlowDao.getAllProcessFlows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProcessFlowVO findProcessFlowbyId(int id) {
		ProcessFlowVO returnobj = new ProcessFlowVO();
		try {
			returnobj= processFlowDao.findProcessFlowbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProcessFlowVO deleteProcessFlowbyId(int id) {
		ProcessFlowVO returnobj = new ProcessFlowVO();
		try {
			returnobj= processFlowDao.deleteProcessFlowbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public ProcessFlowVO saveProcessFlow(ProcessFlowVO obj) {
		ProcessFlowVO returnobj = new ProcessFlowVO();
		try {
			returnobj= processFlowDao.saveProcessFlow(obj) ;
			returnobj.setProcessFlowList(processFlowDao.getAllProcessFlows().getProcessFlowList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


}
