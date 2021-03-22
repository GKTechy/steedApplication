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

import com.app.steedApplication.modules.masters.model.ProcessVO;
import com.app.steedApplication.modules.masters.service.ProcessService;

@RestController
@RequestMapping("/process")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProcessController {

	
	@Autowired
	private ProcessService processService;

	@GetMapping("/allProcesss")
	public ResponseEntity<ProcessVO> getAllProcesss() {
		ProcessVO robj=processService.getAllProcesss();
		return new ResponseEntity<ProcessVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<ProcessVO> findProcessbyId(@PathVariable("id") int id) {
		ProcessVO robj=processService.findProcessbyId(id);
		return new ResponseEntity<ProcessVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProcessVO> deleteProcessbyId(@PathVariable("id") int id) {
		ProcessVO robj=processService.deleteProcessbyId(id);
		return new ResponseEntity<ProcessVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveProcess")
	public ResponseEntity<ProcessVO> saveProcess(@RequestBody ProcessVO obj) {
		ProcessVO robj = new ProcessVO();
		try {
			robj=processService.saveProcess(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<ProcessVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
