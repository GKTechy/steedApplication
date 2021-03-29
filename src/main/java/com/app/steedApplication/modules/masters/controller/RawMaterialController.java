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

import com.app.steedApplication.modules.masters.model.RawMaterialVO;
import com.app.steedApplication.modules.masters.service.RawMaterialService;

@RestController
@RequestMapping("/rawmaterial")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RawMaterialController {
	
	@Autowired
	private RawMaterialService rawMaterialService;

	@GetMapping("/allRawMaterial")
	public ResponseEntity<RawMaterialVO> getAllRawMaterials() {
		RawMaterialVO robj=rawMaterialService.getAllRawMaterials();
		return new ResponseEntity<RawMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<RawMaterialVO> findRawMaterialbyId(@PathVariable("id") int id) {
		RawMaterialVO robj=rawMaterialService.findRawMaterialbyId(id);
		return new ResponseEntity<RawMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RawMaterialVO> deleteRawMaterialbyId(@PathVariable("id") int id) {
		RawMaterialVO robj=rawMaterialService.deleteRawMaterialbyId(id);
		return new ResponseEntity<RawMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveRawMaterial")
	public ResponseEntity<RawMaterialVO> saveRawMaterial(@RequestBody RawMaterialVO obj) {
		RawMaterialVO robj = new RawMaterialVO();
		try {
			robj=rawMaterialService.saveRawMaterial(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<RawMaterialVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

}
