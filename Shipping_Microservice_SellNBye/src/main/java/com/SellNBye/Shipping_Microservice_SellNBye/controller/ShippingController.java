package com.SellNBye.Shipping_Microservice_SellNBye.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SellNBye.Shipping_Microservice_SellNBye.dao.ShippingDAO;
import com.SellNBye.Shipping_Microservice_SellNBye.model.Shipping;

@RestController
@RequestMapping("/SellNBye")
public class ShippingController {

	@Autowired
	ShippingDAO shippingDAO;
	
	/* to save an shipping detail*/
	@PostMapping("/shipping")
	public Shipping createShipping(@Valid @RequestBody Shipping ship) {
		return shippingDAO.save(ship);
	}

	/*get all shipping detail*/
	@GetMapping("/shipping")
	public List<Shipping> getAllshippings(){
		return shippingDAO.findAll();
	}
	
	/*get shipping by sid*/
	@GetMapping("/shipping/{id}")
	public ResponseEntity<Shipping> getShippingById(@PathVariable(value="id") Long sId){
		
		Shipping ship=shippingDAO.findOne(sId);
		
		if(ship==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ship);
		
	}
	
	/*update an shipping detail by sid*/
	@PutMapping("/shipping/{id}")
	
	//pass the value of user id and get user inputs related to that
	public ResponseEntity<Shipping> updateShipping(@PathVariable(value="id") Long sId,@Valid @RequestBody Shipping shippingDetails){ 
		
		Shipping ship=shippingDAO.findOne(sId); //find the records related to id in db table
		if(ship==null) {
			return ResponseEntity.notFound().build();
		}
		
		ship.setShipName(shippingDetails.getShipName());
		ship.setShipInCharge(shippingDetails.getShipInCharge());
		ship.setShippingCost(shippingDetails.getShippingCost());
		ship.setLeaveFrom(shippingDetails.getLeaveFrom());
		ship.setDestination(shippingDetails.getDestination());
		ship.setLeaveDateTime(shippingDetails.getLeaveDateTime());
		ship.setArrivalDateTime(shippingDetails.getArrivalDateTime());
		ship.setDelivery(shippingDetails.getDelivery());
		ship.setShipContactNo(shippingDetails.getShipContactNo());

		Shipping updateShippingDetail=shippingDAO.save(ship);
		return ResponseEntity.ok().body(updateShippingDetail);
			
	}
	
	/*Delete an Shipping record*/
	@DeleteMapping("/shipping/{id}")

	//get the user input id and pass it to sID
	public ResponseEntity<Shipping> deleteShippingDetail(@PathVariable(value="id") Long sId){
		
		Shipping ship=shippingDAO.findOne(sId); //find the related records existence in db table
		if(ship==null) {
			return ResponseEntity.notFound().build();
		}
		shippingDAO.delete(ship); //if record exists delete
		
		return ResponseEntity.ok().build();
		
		
	}
	
} 
