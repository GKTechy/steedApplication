package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.MachineEntity;
import com.app.steedApplication.entity.MachineProcessMap;
import com.app.steedApplication.entity.ProcessEntity;

import lombok.Data;

@Data
public class MachineVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<MachineEntity> machineList;
	public MachineEntity machineObj;
	
	public List<ProcessEntity> processList;
	
	public List<MachineProcessMap> machineProcessMapList;
	public MachineProcessMap machineProcessMapObj;
	
}

