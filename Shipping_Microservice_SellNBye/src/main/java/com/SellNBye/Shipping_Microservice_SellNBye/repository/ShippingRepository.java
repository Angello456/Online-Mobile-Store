package com.SellNBye.Shipping_Microservice_SellNBye.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SellNBye.Shipping_Microservice_SellNBye.model.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Long>  {

}
