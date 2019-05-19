package com.SellNBye.Shipping_Microservice_SellNBye.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SellNBye.Shipping_Microservice_SellNBye.model.Shipping;
import com.SellNBye.Shipping_Microservice_SellNBye.repository.ShippingRepository;



@Service
public class ShippingDAO  {

	@Autowired
	ShippingRepository shippingRepository;
	
	/*to save an Shipping*/
	
	public Shipping save(Shipping ship) {
		return shippingRepository.save(ship);
	}
	
	
	/* search all Shipping*/
	
	public List<Shipping> findAll(){
		return shippingRepository.findAll();
	}
	
	
	/*get an Shipping by id*/
	public Shipping findOne(Long sid) {
		Optional<Shipping> op = shippingRepository.findById(sid);
		if(op.isPresent()) {
		return op.get();
		}
		else {
		return null;
		}
		}
	
	
	/*delete an Shipping*/
	
	public void delete(Shipping ship) {
		shippingRepository.delete(ship);
	}
}
