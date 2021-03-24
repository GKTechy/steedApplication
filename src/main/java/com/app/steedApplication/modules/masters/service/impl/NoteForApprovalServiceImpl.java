package com.app.steedApplication.modules.masters.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.steedApplication.modules.masters.dao.NoteForApprovalDao;
import com.app.steedApplication.modules.masters.model.NoteForApprovalVO;
import com.app.steedApplication.modules.masters.service.NoteForApprovalService;

@Service
@Transactional
public class NoteForApprovalServiceImpl implements NoteForApprovalService {

	@Autowired
	private NoteForApprovalDao noteForApprovalDao;

	
	@Override
	public NoteForApprovalVO getAllNoteForApprovals() {
		NoteForApprovalVO returnobj = new NoteForApprovalVO();
		try {
			returnobj= noteForApprovalDao.getAllNoteForApprovals();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public NoteForApprovalVO findNoteForApprovalbyId(int id) {
		NoteForApprovalVO returnobj = new NoteForApprovalVO();
		try {
			returnobj= noteForApprovalDao.findNoteForApprovalbyId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public NoteForApprovalVO deleteNoteForApprovalbyId(int id) {
		NoteForApprovalVO returnobj = new NoteForApprovalVO();
		try {
			returnobj= noteForApprovalDao.deleteNoteForApprovalbyId(id) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}


	@Override
	public NoteForApprovalVO saveNoteForApproval(NoteForApprovalVO obj) {
		NoteForApprovalVO returnobj = new NoteForApprovalVO();
		try {
			returnobj= noteForApprovalDao.saveNoteForApproval(obj) ;
			returnobj.setNoteForApprovalList(noteForApprovalDao.getAllNoteForApprovals().getNoteForApprovalList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnobj;
	}

}
