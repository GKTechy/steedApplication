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

import com.app.steedApplication.modules.masters.model.RoleVO;
import com.app.steedApplication.modules.masters.service.RoleService;

/**
 * @author GK 
 *
 */
@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@GetMapping("/allRoles")
	public ResponseEntity<RoleVO> getAllRoles() {
		RoleVO robj=roleService.getAllRoles();
		return new ResponseEntity<RoleVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<RoleVO> findRolebyId(@PathVariable("id") int id) {
		RoleVO robj=roleService.findRolebyId(id);
		return new ResponseEntity<RoleVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RoleVO> deleteRolebyId(@PathVariable("id") int id) {
		RoleVO robj=roleService.deleteRolebyId(id);
		return new ResponseEntity<RoleVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveRole")
	public ResponseEntity<RoleVO> saveRole(@RequestBody RoleVO obj) {
		RoleVO robj = new RoleVO();
		try {
			robj=roleService.saveRole(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<RoleVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
}
