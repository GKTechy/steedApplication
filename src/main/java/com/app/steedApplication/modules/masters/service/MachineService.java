package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.MachineVO;

public interface MachineService {

	MachineVO getAllMachines();

	MachineVO findMachinebyId(int id);

	MachineVO deleteMachinebyId(int id);

	MachineVO saveMachine(MachineVO obj);

	MachineVO allMachinesProcessMapDetails();

	MachineVO saveMachinesProcessMapDetails(MachineVO obj);

}
