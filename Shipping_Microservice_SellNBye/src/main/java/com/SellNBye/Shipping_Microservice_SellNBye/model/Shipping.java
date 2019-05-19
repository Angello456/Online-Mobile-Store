package com.SellNBye.Shipping_Microservice_SellNBye.model;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity // mark this class as entity
@Table(name="Shipping",	uniqueConstraints={@UniqueConstraint(columnNames = "shipName")}) // define table for the entity and make shipName column unique


@EntityListeners(AuditingEntityListener.class)

public class Shipping {

	@Id     // primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //make primary key auto increment
	private Long sId;
	
	@NotBlank(message="Ship Name is mandatory !")      // shipName should not be null
	private String shipName;
	
	@NotBlank(message="Ship In Charge Name is mandatory !")
	private String shipInCharge;
	
	@NotBlank(message="Shipping cost is mandatory !")
	private String shippingCost;
	
	@NotBlank(message="This filed is mandatory !")
	private String leaveFrom;
	
	@NotBlank(message="Destination is mandatory !")
	private String destination;
	
	@NotNull(message="This field is mandatory !")
	private LocalDateTime  leaveDateTime;
	
	@NotNull(message="This field is mandatory !")
	private LocalDateTime arrivalDateTime;
	
	@NotBlank(message="This field is mandatory !")
	private String delivery;
	
	@NotBlank(message="Contact No cannot be empty !")
	@Pattern(regexp="(^$|[0-9]{10})",message="Enter valid contact No !")
	private String shipContactNo;

	@LastModifiedDate
	private LocalDateTime createdAt;

	public Long getsId() {
		return sId;
	}

	public void setsId(Long sId) {
		this.sId = sId;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipInCharge() {
		return shipInCharge;
	}

	public void setShipInCharge(String shipInCharge) {
		this.shipInCharge = shipInCharge;
	}

	public String getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(String shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getLeaveFrom() {
		return leaveFrom;
	}

	public void setLeaveFrom(String leaveFrom) {
		this.leaveFrom = leaveFrom;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getLeaveDateTime() {
		return leaveDateTime;
	}

	public void setLeaveDateTime(LocalDateTime leaveDateTime) {
		this.leaveDateTime = leaveDateTime;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public String getShipContactNo() {
		return shipContactNo;
	}

	public void setShipContactNo(String shipContactNo) {
		this.shipContactNo = shipContactNo;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
}
