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

import com.app.steedApplication.modules.masters.model.SupplierVO;
import com.app.steedApplication.modules.masters.service.SupplierService;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SupplierController {
	

	@Autowired
	private SupplierService supplierService;

	@GetMapping("/allSuppliers")
	public ResponseEntity<SupplierVO> getAllSuppliers() {
		SupplierVO robj=supplierService.getAllSupplier();
		return new ResponseEntity<SupplierVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<SupplierVO> findSupplierbyId(@PathVariable("id") int id) {
		SupplierVO robj=supplierService.findSupplierbyId(id);
		return new ResponseEntity<SupplierVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<SupplierVO> deleteSupplierbyId(@PathVariable("id") int id) {
		SupplierVO robj=supplierService.deleteSupplierbyId(id);
		return new ResponseEntity<SupplierVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveSupplier")
	public ResponseEntity<SupplierVO> saveSupplier(@RequestBody SupplierVO obj) {
		SupplierVO robj = new SupplierVO();
		try {
			robj=supplierService.saveSupplier(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<SupplierVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
}
