package com.app.steedApplication.modules.masters.service;

import com.app.steedApplication.modules.masters.model.NoteForApprovalVO;

public interface NoteForApprovalService {

	NoteForApprovalVO findNoteForApprovalbyId(int id);

	NoteForApprovalVO deleteNoteForApprovalbyId(int id);

	NoteForApprovalVO saveNoteForApproval(NoteForApprovalVO obj);

	NoteForApprovalVO getAllNoteForApprovals();

}
