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

import com.app.steedApplication.modules.masters.model.DealerOrderVO;
import com.app.steedApplication.modules.masters.service.DealerOrderService;

@RestController
@RequestMapping("/DealerOrder")
@CrossOrigin(origins = "*", allowedHeaders = "*")


public class DealerOrderController {
	
	@Autowired
	private DealerOrderService dealerOrderService;

	@GetMapping("/allDealerOrders")
	public ResponseEntity<DealerOrderVO> getAllDealerOrders() {
		DealerOrderVO robj=dealerOrderService.getAllDealerOrder();
		return new ResponseEntity<DealerOrderVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<DealerOrderVO> findDealerOrderbyId(@PathVariable("id") int id) {
		DealerOrderVO robj=dealerOrderService.findDealerOrderbyId(id);
		return new ResponseEntity<DealerOrderVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DealerOrderVO> deleteDealerOrderbyId(@PathVariable("id") int id) {
		DealerOrderVO robj=dealerOrderService.deleteDealerOrderbyId(id);
		return new ResponseEntity<DealerOrderVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveDealerOrder")
	public ResponseEntity<DealerOrderVO> saveDealerOrder(@RequestBody DealerOrderVO obj) {
		DealerOrderVO robj = new DealerOrderVO();
		try {
			robj=dealerOrderService.saveDealerOrder(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<DealerOrderVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}

	

}
