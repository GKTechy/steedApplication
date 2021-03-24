package com.app.steedApplication.modules.masters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.steedApplication.modules.masters.model.NoteForApprovalVO;
import com.app.steedApplication.modules.masters.service.NoteForApprovalService;

@RestController
@RequestMapping("/noteforapproval")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NoteForApprovalController {
	

	@Autowired
	private NoteForApprovalService noteForApprovalService;

	@GetMapping("/allNoteForApprovals")
	public ResponseEntity<NoteForApprovalVO> getAllNoteForApprovals() {
		NoteForApprovalVO robj=noteForApprovalService.getAllNoteForApprovals();
		return new ResponseEntity<NoteForApprovalVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<NoteForApprovalVO> findNoteForApprovalbyId(@PathVariable("id") int id) {
		NoteForApprovalVO robj=noteForApprovalService.findNoteForApprovalbyId(id);
		return new ResponseEntity<NoteForApprovalVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<NoteForApprovalVO> deleteNoteForApprovalbyId(@PathVariable("id") int id) {
		NoteForApprovalVO robj=noteForApprovalService.deleteNoteForApprovalbyId(id);
		return new ResponseEntity<NoteForApprovalVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveNoteForApproval")
	public ResponseEntity<NoteForApprovalVO> saveNoteForApproval(@RequestBody NoteForApprovalVO obj) {
		NoteForApprovalVO robj = new NoteForApprovalVO();
		try {
			robj=noteForApprovalService.saveNoteForApproval(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<NoteForApprovalVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
