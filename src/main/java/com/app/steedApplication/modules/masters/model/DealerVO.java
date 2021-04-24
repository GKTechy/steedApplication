package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.DealerEntity;
import com.app.steedApplication.entity.SequenceEntity;

import lombok.Data;

@Data
public class DealerVO {
	
	public Boolean valid;
	public String responseMsg;
	public List<DealerEntity> dealerList;
	public DealerEntity dealerObj;
	
	public SequenceEntity sObj;
	
}
