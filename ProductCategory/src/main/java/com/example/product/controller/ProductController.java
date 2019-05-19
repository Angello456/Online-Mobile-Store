package com.example.product.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Product;
import com.example.product.model.ServiceResponse;
import com.example.product.services.ProductServices;;


@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductServices services;
	 
	 @GetMapping("/products")
	 public List<Product> getAllProducts(){
		 return services.getAllProducts();
	 }
//	@GetMapping("/products")
//	public ServiceResponse getAllProducts(){
//		List<Product> products=services.getAllProducts();
//		ServiceResponse response=new ServiceResponse("success",products);
//		return response;
//	 }
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value="id")Long id){
		Product productx=services.getProduct(id);
		if(productx==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(productx);
	}
	
	@PostMapping("/products")
	public ServiceResponse createProducts(@Valid @RequestBody Product product) {
		services.addProduct(product);
		ServiceResponse response=new ServiceResponse("success",product);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/products/{id}")
	public ServiceResponse updateProduct(@RequestBody Product product,@PathVariable Long id) {
		services.updateProduct(id, product);
		ServiceResponse response=new ServiceResponse("success",product);
		return response;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		services.deleteProduct(id);
	}
	
}
