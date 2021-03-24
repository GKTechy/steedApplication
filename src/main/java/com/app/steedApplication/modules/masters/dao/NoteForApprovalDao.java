package com.app.steedApplication.modules.masters.dao;

import com.app.steedApplication.modules.masters.model.NoteForApprovalVO;

public interface NoteForApprovalDao {

	NoteForApprovalVO getAllNoteForApprovals();

	NoteForApprovalVO findNoteForApprovalbyId(int id);

	NoteForApprovalVO deleteNoteForApprovalbyId(int id);

	NoteForApprovalVO saveNoteForApproval(NoteForApprovalVO obj);

}
