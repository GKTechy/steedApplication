package com.app.steedApplication.modules.masters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.app.steedApplication.modules.masters.model.DealerVO;
import com.app.steedApplication.modules.masters.service.DealerService;

public class DealerController {
	
	@Autowired
	private DealerService dealerService;

	@GetMapping("/allDealers")
	public ResponseEntity<DealerVO> getAllDealers() {
		DealerVO robj=dealerService.getAllDealer();
		return new ResponseEntity<DealerVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<DealerVO> findDealerbyId(@PathVariable("id") int id) {
		DealerVO robj=dealerService.finddealerbyId(id);
		return new ResponseEntity<DealerVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DealerVO> deleteDealerbyId(@PathVariable("id") int id) {
		DealerVO robj=dealerService.deleteDealerbyId(id);
		return new ResponseEntity<DealerVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveDealer")
	public ResponseEntity<DealerVO> saveDealer(@RequestBody DealerVO obj) {
		DealerVO robj = new DealerVO();
		try {
			robj=dealerService.saveDealer(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<DealerVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
		
	@GetMapping("/allDealerDetails")
	public ResponseEntity<DealerVO> allDealerDetails() {
		DealerVO robj=dealerService.allDealerDetails();
		return new ResponseEntity<DealerVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/saveDealerDetails")
	public ResponseEntity<DealerVO> saveDealerDetails(@RequestBody DealerVO obj) {
		DealerVO robj = new DealerVO();
		try {
			robj=dealerService.saveDealerDetails(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<DealerVO>(robj,new HttpHeaders(),HttpStatus.OK);

	}
	
}
