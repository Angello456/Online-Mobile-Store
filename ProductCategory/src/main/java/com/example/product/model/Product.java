package com.example.product.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="products")
@EntityListeners(AuditingEntityListener.class)
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Code", length =8, nullable = false)
	private Long code;
	
	@Column(name = "Name", length = 255)
	@NotBlank(message = "Name may not be null")
	private String name;
	
	@Column(name = "Price")
	//@NotNull(message = "Price may not be null")
	private float price;
	
	@Column(name = "Qty")
	//@NotNull(message = "Quantity may not be null")
	private int qyt;
	
	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;
	 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Create_Date", nullable = true)
	private Date createDate;
	
	@Column(name = "ShopId", length =30)
	@NotNull(message = "Name may not be null")
	private Long shop_id;
	
	
	
//	public Product(String Name,float Price,int Qty,byte[] Image,Date cDate,Long Shop_id){
//		super();
//		this.name=Name;
//		this.price=Price;
//		this.qyt=Qty;
//		this.image=Image;
//		this.createDate=cDate;
//		this.shop_id=Shop_id;
//	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQyt() {
		return qyt;
	}

	public void setQyt(int qyt) { 
		this.qyt = qyt;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getShop_id() {
		return shop_id;
	}

	public void setShop_id(Long shop_id) {
		this.shop_id = shop_id;
	}


}
