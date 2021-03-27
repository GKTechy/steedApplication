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

import com.app.steedApplication.modules.masters.model.UOMVO;
import com.app.steedApplication.modules.masters.service.UOMService;

@RestController
@RequestMapping("/uom")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UOMController {
	
	@Autowired
	private UOMService UOMService;

	@GetMapping("/allUOMs")
	public ResponseEntity<UOMVO> getAllUOMs() {
		UOMVO robj=UOMService.getAllUOMs();
		return new ResponseEntity<UOMVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<UOMVO> findUOMbyId(@PathVariable("id") int id) {
		UOMVO robj=UOMService.findUOMbyId(id);
		return new ResponseEntity<UOMVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UOMVO> deleteUOMbyId(@PathVariable("id") int id) {
		UOMVO robj=UOMService.deleteUOMbyId(id);
		return new ResponseEntity<UOMVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveUOM")
	public ResponseEntity<UOMVO> saveUOM(@RequestBody UOMVO obj) {
		UOMVO robj = new UOMVO();
		try {
			robj=UOMService.saveUOM(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<UOMVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

}
