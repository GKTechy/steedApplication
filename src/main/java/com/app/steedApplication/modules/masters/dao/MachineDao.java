package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.MachineVO;

public interface MachineDao {
	
	MachineVO getAllMachines();

	MachineVO findMachinebyId(int id);

	MachineVO deleteMachinebyId(int id);

	MachineVO saveMachine(MachineVO obj);

	MachineVO allMachinesProcessMapDetails();

	MachineVO saveMachinesProcessMapDetails(MachineVO obj);
	
}
