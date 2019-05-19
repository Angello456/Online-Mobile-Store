package com.placeorderservice.placeorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.placeorderservice.placeorder.model.Order;
import com.placeorderservice.placeorder.service.RestClientService;

@Controller
@RequestMapping("/")
public class OrderController {

	 //define a service constant
    private final RestClientService service;


    @Autowired
    public OrderController(RestClientService service){
       this.service = service;
    }

  
   
    @GetMapping("Order")
    public String getAll(Model model){
        model.addAttribute("order", service.findAllOrders());
        return "orders";
    }

    @RequestMapping("/Order/{id}")
    public String getById(@PathVariable String id, Model model){
        model.addAttribute("order", service.findOrderById(id));
        return "showorder";
    }
    
    @PostMapping("/placeorder")
    public String placeOrder(@ModelAttribute Order order) {
        return "result";
    }
    
   
    /*
    @GetMapping("/delete")
    public String gotodelete(@ModelAttribute Order del) {
    return "delete";
    } 
    */
    
    /*@PostMapping("/delete")
    public void delete(@ModelAttribute Order del){
        service.deleteOrder(del);
        
    }*/
    
    
}
