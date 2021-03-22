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

import com.app.steedApplication.modules.masters.model.PaymentTermVO;
import com.app.steedApplication.modules.masters.service.PaymentTermService;

@RestController
@RequestMapping("/paymentTerm")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentTermController {
	
	
	@Autowired
	private PaymentTermService paymentTermService;

	@GetMapping("/allPaymentTerms")
	public ResponseEntity<PaymentTermVO> getAllPaymentTerms() {
		PaymentTermVO robj=paymentTermService.getAllPaymentTerms();
		return new ResponseEntity<PaymentTermVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<PaymentTermVO> findPaymentTermbyId(@PathVariable("id") int id) {
		PaymentTermVO robj=paymentTermService.findPaymentTermbyId(id);
		return new ResponseEntity<PaymentTermVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PaymentTermVO> deletePaymentTermbyId(@PathVariable("id") int id) {
		PaymentTermVO robj=paymentTermService.deletePaymentTermbyId(id);
		return new ResponseEntity<PaymentTermVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/savePaymentTerm")
	public ResponseEntity<PaymentTermVO> savePaymentTerm(@RequestBody PaymentTermVO obj) {
		PaymentTermVO robj = new PaymentTermVO();
		try {
			robj=paymentTermService.savePaymentTerm(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<PaymentTermVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
