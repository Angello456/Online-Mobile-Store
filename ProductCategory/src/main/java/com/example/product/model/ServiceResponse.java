package com.example.product.model;

import java.util.List;

public class ServiceResponse{
	
	private String status;
	private Product product;
	private List<Product> allProducts;
	
	public ServiceResponse(String status,Product prod) {
		this.status=status;
		this.product=prod;
	}
	
	public ServiceResponse(String status2, List<Product> products) {
		this.status=status2;
		this.allProducts=products;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Product getData() {
		return product;
	}
	public void setData(Product product) {
		this.product = product;
	}

	public List<Product> getAllProducts() {
		return allProducts;
	}


	public void setAllProducts(List<Product> allProducts) {
		this.allProducts = allProducts;
	}

}
