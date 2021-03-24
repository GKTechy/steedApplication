package com.app.steedApplication.modules.masters.model;

import java.util.List;

import com.app.steedApplication.entity.NoteForApprovalEntity;

import lombok.Data;

@Data
public class NoteForApprovalVO {


	public Boolean valid;
	public String responseMsg;
	public List<NoteForApprovalEntity> noteForApprovalList;
	public NoteForApprovalEntity noteForApprovalObj;
	
}
