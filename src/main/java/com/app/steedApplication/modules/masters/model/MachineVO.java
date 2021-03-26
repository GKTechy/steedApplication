package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.MachineEntity;

import lombok.Data;

@Data
public class MachineVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<MachineEntity> machineList;
	public MachineEntity machineTypeObj;
}
