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

import com.app.steedApplication.modules.masters.model.OrderCodeVO;
import com.app.steedApplication.modules.masters.service.OrderCodeService;

@RestController
@RequestMapping("/ordercode")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderCodeController {
	

	@Autowired
	private OrderCodeService orderCodeService;

	@GetMapping("/allOrderCodes")
	public ResponseEntity<OrderCodeVO> getAllOrderCodes() {
		OrderCodeVO robj=orderCodeService.getAllOrderCodes();
		return new ResponseEntity<OrderCodeVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<OrderCodeVO> findOrderCodebyId(@PathVariable("id") int id) {
		OrderCodeVO robj=orderCodeService.findOrderCodebyId(id);
		return new ResponseEntity<OrderCodeVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<OrderCodeVO> deleteOrderCodebyId(@PathVariable("id") int id) {
		OrderCodeVO robj=orderCodeService.deleteOrderCodebyId(id);
		return new ResponseEntity<OrderCodeVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveOrderCode")
	public ResponseEntity<OrderCodeVO> saveOrderCode(@RequestBody OrderCodeVO obj) {
		OrderCodeVO robj = new OrderCodeVO();
		try {
			robj=orderCodeService.saveOrderCode(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<OrderCodeVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	
}
