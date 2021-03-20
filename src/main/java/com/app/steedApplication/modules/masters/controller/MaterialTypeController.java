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

import com.app.steedApplication.modules.masters.model.MaterialTypeVO;
import com.app.steedApplication.modules.masters.service.MaterialTypeService;



@RestController
@RequestMapping("/mateialtype")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MaterialTypeController {

	
	@Autowired
	private MaterialTypeService materialTypeService;

	@GetMapping("/allMaterialTypes")
	public ResponseEntity<MaterialTypeVO> getAllMaterialTypes() {
		MaterialTypeVO robj=materialTypeService.getAllMaterialTypes();
		return new ResponseEntity<MaterialTypeVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<MaterialTypeVO> findMaterialTypebyId(@PathVariable("id") int id) {
		MaterialTypeVO robj=materialTypeService.findMaterialTypebyId(id);
		return new ResponseEntity<MaterialTypeVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MaterialTypeVO> deleteMaterialTypebyId(@PathVariable("id") int id) {
		MaterialTypeVO robj=materialTypeService.deleteMaterialTypebyId(id);
		return new ResponseEntity<MaterialTypeVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveMaterialType")
	public ResponseEntity<MaterialTypeVO> saveMaterialType(@RequestBody MaterialTypeVO obj) {
		MaterialTypeVO robj = new MaterialTypeVO();
		try {
			robj=materialTypeService.saveMaterialType(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<MaterialTypeVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	
}
