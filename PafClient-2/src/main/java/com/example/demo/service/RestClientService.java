package com.example.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Product;

@Service
public class RestClientService {

	//private final RestTemplate restTemplate;

	private final String GET_ALL_URL = "http://localhost:9090/products/";
	private final String GET_URL_BY_ID = "http://localhost:9090/products/";
	private final String PUT_UPDATE_BY_ID = "http://localhost:9090/products/";
	//private final String DELETE_BY_ID="http://localhost:9090/products/{code}";

	private final RestTemplate RestTemplate;
	@Autowired
    public RestClientService(RestTemplate restTemplate){
        this.RestTemplate = restTemplate;
    }
	
	
	public List<Product> findAllProducts(){
		
		return Arrays.stream(RestTemplate.getForObject(GET_ALL_URL,Product[].class)).collect(Collectors.toList());
	}
	
	public Product findProductById(long code){
		return RestTemplate.getForObject(GET_URL_BY_ID + code,Product.class);
	}
	
	public Product updateById(long code){
		return RestTemplate.getForObject(PUT_UPDATE_BY_ID + code,Product.class);
	}
	
	public void deleteById(Product product) {
		Map<String,Long> params=new HashMap<String,Long>();
		params.put("code",product.getCode());
		RestTemplate.delete("http://localhost:9090/products/{code}",params);
	}
	
	public void createProduct(Product product) {
		RestTemplate.postForLocation("http://localhost:9090/products",product,Product.class);
		
	}
    
}
