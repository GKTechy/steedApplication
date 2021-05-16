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

import com.app.steedApplication.entity.UserEntity;
import com.app.steedApplication.modules.masters.model.UserVO;
import com.app.steedApplication.modules.masters.service.UserService;


/**
 * @author GK 
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	
	@GetMapping("/allUsers")
	public ResponseEntity<UserVO> getAllUsers() {
		UserVO robj=userService.getAllUsers();
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserVO> findUserbyId(@PathVariable("id") int id) {
		UserVO robj=userService.findUserbyId(id);
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserVO> deleteUserbyId(@PathVariable("id") int id) {
		UserVO robj=userService.deleteUserbyId(id);
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	

	@PostMapping
	public  ResponseEntity<UserVO> CreateOrUpdateUser(@RequestBody UserEntity user) {
		UserVO robj=userService.CreateOrUpdateUser(user);
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/userLogin")
	public ResponseEntity<UserVO> userLogin(@RequestParam(name = "userName") String userName,@RequestParam(name = "userPassword") String userPassword) throws Exception {
		UserVO robj = new UserVO();
		try {
			 robj = userService.userLogin(userName,userPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/changePassword")
	public ResponseEntity<UserVO> changePassword(@RequestParam(name = "userName") String userName,@RequestParam(name = "currentPassword") String currentPassword,@RequestParam(name = "newPassword") String newPassword) throws Exception {
		UserVO robj = new UserVO();
		try {
			robj = userService.changePassword(userName,currentPassword,newPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<UserVO> forgotPassword(@RequestParam(name = "userName") String userName,@RequestParam(name = "currentPassword") String currentPassword,@RequestParam(name = "newPassword") String newPassword) throws Exception {
		UserVO robj = new UserVO();
		try {
			robj = userService.forgotPassword(userName,currentPassword,newPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/saveUserList")
	public ResponseEntity<UserVO> saveUserList(@RequestBody UserVO userVO) {
		UserVO robj = new UserVO();
		try {
			robj=userService.saveUserList(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/deleteUser")
	public ResponseEntity<UserVO> deleteUser(@RequestParam(name = "id") int id,@RequestParam(name = "employeeId") String employeeId,@RequestParam(name = "loginUser") String loginUser,@RequestParam(name = "companyCode") String companyCode) throws Exception {
		UserVO robj = new UserVO();
		try {
			robj = userService.deleteUser(id,employeeId,loginUser,companyCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/resetPassword")
	public ResponseEntity<UserVO> resetPassword(@RequestBody UserVO userVO) {
		UserVO robj = new UserVO();
		try {
			robj=userService.resetPassword(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<UserVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}