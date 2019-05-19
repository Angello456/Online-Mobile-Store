package com.placeorderservice.placeorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placeorderservice.placeorder.model.order;

@Repository
public interface orderRepository extends JpaRepository<order, Long> {

}
