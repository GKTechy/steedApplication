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

import com.app.steedApplication.modules.masters.model.ProductVO;
import com.app.steedApplication.modules.masters.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	

	@Autowired
	private ProductService productService;

	@GetMapping("/allProducts")
	public ResponseEntity<ProductVO> getAllProducts() {
		ProductVO robj=productService.getAllProducts();
		return new ResponseEntity<ProductVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<ProductVO> findProductbyId(@PathVariable("id") int id) {
		ProductVO robj=productService.findProductbyId(id);
		return new ResponseEntity<ProductVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductVO> deleteProductbyId(@PathVariable("id") int id) {
		ProductVO robj=productService.deleteProductbyId(id);
		return new ResponseEntity<ProductVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/saveProduct")
	public ResponseEntity<ProductVO> saveProduct(@RequestBody ProductVO obj) {
		ProductVO robj = new ProductVO();
		try {
			robj=productService.saveProduct(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<ProductVO>(robj,new HttpHeaders(),HttpStatus.OK);
	}
	
	
}
