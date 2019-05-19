package com.example.product.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;


@Service
public class ProductServices {
	
		@Autowired
		private ProductRepository productRepository;

		
		public List<Product> getAllProducts() {
			List<Product> products=new ArrayList<>();
			productRepository.findAll()
			.forEach(products::add);
			return products;
		}
		
		public Product getProduct(Long id) {
			return productRepository.findOne(id);
		}

		public Product addProduct(Product product) {
			return productRepository.save(product);
		}
		
//	
		public Product updateProduct(Long id,Product product) {
			Product productdb=productRepository.getOne(id);
			productdb.setName(product.getName());
			productdb.setImage(product.getImage());
			productdb.setPrice(product.getPrice());
			productdb.setQyt(product.getQyt());
			productRepository.save(productdb);
			return productdb;
		}

		public void deleteProduct(Long id) {
			productRepository.delete(id);
		}

}
