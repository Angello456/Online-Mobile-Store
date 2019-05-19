package com.placeorderservice.placeorder.controller;

import com.placeorderservice.placeorder.exception.ResourceNotFoundException;
import com.placeorderservice.placeorder.model.order;
import com.placeorderservice.placeorder.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class orderController {

	@Autowired
	orderRepository orderRepo;
	
	//Get All orders
	@GetMapping("/all")
	public List<order> getAllorders() {
	    return orderRepo.findAll();
	}
	
	//Place a new order
	@PostMapping("/orders")
	public order placeorder(@Valid @RequestBody order ord) {
	    return orderRepo.save(ord);
	}
	
	//Get a single order
	 @GetMapping("/order/{id}")
	 public order getorderById(@PathVariable(value = "id") Long orderId) {
	        return orderRepo.findById(orderId)
	                .orElseThrow(() -> new ResourceNotFoundException("order", "id", orderId));
	    }
	
	 
	 //Update order
	
	 @PutMapping("/orders/{id}")
	 public order updateorder(@PathVariable(value = "id") Long orderId,
	                                         @Valid @RequestBody order orderDetails) {

	     order orders = orderRepo.findById(orderId)
	             .orElseThrow(() -> new ResourceNotFoundException("order", "id", orderId));

	     orders.setQty(orderDetails.getQty());

	     order updatedorder = orderRepo.save(orders);
	     return updatedorder;
	 }
	
	 //Delete am order
	
	 @DeleteMapping("/orders/{id}")
	 public ResponseEntity<?> deleteorder(@PathVariable(value = "id") Long orderId) {
	     order orders = orderRepo.findById(orderId)
	             .orElseThrow(() -> new ResourceNotFoundException("order", "id", orderId));

	     orderRepo.delete(orders);

	     return ResponseEntity.ok().build();
	 }
	 
	 
}
