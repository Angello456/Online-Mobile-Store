package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Product;
import com.example.demo.service.RestClientService;

@Controller
@RequestMapping("/api")
public class ProductController {

	private final RestClientService service;
	
	@Autowired
    public ProductController(RestClientService service){
    this.service = service;
    }
	
    @GetMapping("/products")
    public String getAll(Model model){
    	List<Product> prod = service.findAllProducts();
    	model.addAttribute("product",prod);
        return "products";
    }
    
    
    @RequestMapping("/products/{id}")
    public String getById(@PathVariable long id, Model model){
        model.addAttribute("product",service.findProductById(id));
        return "productsId";
    }
    
//    @RequestMapping(method=RequestMethod.PUT,value="/products/{id}")
//    public String updateById(@RequestBody Product product,@PathVariable Long id,Model model) {
//    	model.asMap()
//    }
    
    @GetMapping("/delete")
    public String deleteById(@ModelAttribute Product product){
    	return "delete";
    }  
    
    @PostMapping("/delete")
    public String deleteFunc(@ModelAttribute Product product,Model model) {
    	service.deleteById(product);
    	model.addAttribute("product",product);
    	return "redirect:products";
    }
    
    @GetMapping("/add")
    public String addById(@ModelAttribute Product product){
    	return "addProduct";
    }
    
    @PostMapping("/add")
    public String addDetails(@ModelAttribute Product product,Model model) {
    	service.createProduct(product);
    	//model
    	model.addAttribute("product",product);
    	return "redirect:products";
    }
    
    
    

}
