package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.MachineDao;
import com.app.steedApplication.modules.masters.dao.ProcessDao;
import com.app.steedApplication.modules.masters.model.MachineVO;
import com.app.steedApplication.modules.masters.service.MachineService;


@Service
@Transactional
public class MachineServiceImpl implements MachineService {

	@Autowired
	private MachineDao machineDao;

	@Autowired
	private ProcessDao processDao;
	
	
	@Override
	public MachineVO getAllMachines() {
		MachineVO returnobj = new MachineVO();
		try {
			returnobj= machineDao.getAllMachines();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public MachineVO findMachinebyId(int id) {
		MachineVO returnobj = new MachineVO();
		try {
			returnobj= machineDao.findMachinebyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public MachineVO deleteMachinebyId(int id) {
		MachineVO returnobj = new MachineVO();
		try {
			returnobj= machineDao.deleteMachinebyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public MachineVO saveMachine(MachineVO obj) {
		MachineVO returnobj = new MachineVO();
		try {
			returnobj= machineDao.saveMachine(obj) ;
			returnobj.setMachineList(machineDao.getAllMachines().getMachineList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public MachineVO allMachinesProcessMapDetails() {
		MachineVO returnobj = new MachineVO();
		try {
			returnobj= machineDao.allMachinesProcessMapDetails() ;
			returnobj.setMachineList(machineDao.getAllMachines().getMachineList());
			returnobj.setProcessList(processDao.getAllProcesss().getProcessList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public MachineVO saveMachinesProcessMapDetails(MachineVO obj) {
		MachineVO returnobj = new MachineVO();
		try {
			returnobj= machineDao.saveMachinesProcessMapDetails(obj) ;
			returnobj.setMachineProcessMapList(machineDao.allMachinesProcessMapDetails().getMachineProcessMapList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


}
