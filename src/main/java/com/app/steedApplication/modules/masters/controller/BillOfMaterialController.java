
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.steedApplication.modules.masters.model.BillOfMaterialVO;
import com.app.steedApplication.modules.masters.service.BillOfMaterialService;

@RestController
@RequestMapping("/billOfMaterial")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillOfMaterialController {
	
	@Autowired
	private BillOfMaterialService billOfMaterialService;

	@GetMapping("/allBillOfMaterials")
	public ResponseEntity<BillOfMaterialVO> getAllBillOfMaterials() {
		BillOfMaterialVO robj=billOfMaterialService.getAllBillOfMaterial();
		return new ResponseEntity<BillOfMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@GetMapping("/productBoms")
	public ResponseEntity<BillOfMaterialVO> productBoms(@RequestParam(name = "productId") int productId) {
		BillOfMaterialVO robj=billOfMaterialService.productBoms(productId);
		return new ResponseEntity<BillOfMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BillOfMaterialVO> findBillOfMaterialbyId(@PathVariable("id") int id) {
		BillOfMaterialVO robj=billOfMaterialService.findBillOfMaterialbyId(id);
		return new ResponseEntity<BillOfMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<BillOfMaterialVO> deleteBillOfMaterialbyId(@PathVariable("id") int id) {
		BillOfMaterialVO robj=billOfMaterialService.deleteBillOfMaterialbyId(id);
		return new ResponseEntity<BillOfMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveBillOfMaterial")
	public ResponseEntity<BillOfMaterialVO> saveBillOfMaterial(@RequestBody BillOfMaterialVO obj) {
		BillOfMaterialVO robj = new BillOfMaterialVO();
		try {
			robj=billOfMaterialService.saveBillOfMaterial(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<BillOfMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}

	

}
