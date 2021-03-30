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

import com.app.steedApplication.modules.masters.model.MachineVO;
import com.app.steedApplication.modules.masters.service.MachineService;

@RestController
@RequestMapping("/machine")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MachineController {
	
	@Autowired
	private MachineService machineService;

	@GetMapping("/allMachines")
	public ResponseEntity<MachineVO> getAllMachines() {
		MachineVO robj=machineService.getAllMachines();
		return new ResponseEntity<MachineVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<MachineVO> findMachinebyId(@PathVariable("id") int id) {
		MachineVO robj=machineService.findMachinebyId(id);
		return new ResponseEntity<MachineVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MachineVO> deleteMachinebyId(@PathVariable("id") int id) {
		MachineVO robj=machineService.deleteMachinebyId(id);
		return new ResponseEntity<MachineVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveMachine")
	public ResponseEntity<MachineVO> saveMachine(@RequestBody MachineVO obj) {
		MachineVO robj = new MachineVO();
		try {
			robj=machineService.saveMachine(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<MachineVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
		
	@GetMapping("/allMachinesProcessMapDetails")
	public ResponseEntity<MachineVO> allMachinesProcessMapDetails() {
		MachineVO robj=machineService.allMachinesProcessMapDetails();
		return new ResponseEntity<MachineVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/saveMachinesProcessMapDetails")
	public ResponseEntity<MachineVO> saveMachinesProcessMapDetails(@RequestBody MachineVO obj) {
		MachineVO robj = new MachineVO();
		try {
			robj=machineService.saveMachinesProcessMapDetails(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<MachineVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
}
