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

import com.app.steedApplication.modules.masters.model.ProcessFlowVO;
import com.app.steedApplication.modules.masters.service.ProcessFlowService;

@RestController
@RequestMapping("/processflow")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProcessFlowController {
	

	
	@Autowired
	private ProcessFlowService processFlowService;

	@GetMapping("/allProcessFlows")
	public ResponseEntity<ProcessFlowVO> getAllProcessFlows() {
		ProcessFlowVO robj=processFlowService.getAllProcessFlows();
		return new ResponseEntity<ProcessFlowVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<ProcessFlowVO> findProcessFlowbyId(@PathVariable("id") int id) {
		ProcessFlowVO robj=processFlowService.findProcessFlowbyId(id);
		return new ResponseEntity<ProcessFlowVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProcessFlowVO> deleteProcessFlowbyId(@PathVariable("id") int id) {
		ProcessFlowVO robj=processFlowService.deleteProcessFlowbyId(id);
		return new ResponseEntity<ProcessFlowVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveProcessFlow")
	public ResponseEntity<ProcessFlowVO> saveProcessFlow(@RequestBody ProcessFlowVO obj) {
		ProcessFlowVO robj = new ProcessFlowVO();
		try {
			robj=processFlowService.saveProcessFlow(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<ProcessFlowVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
