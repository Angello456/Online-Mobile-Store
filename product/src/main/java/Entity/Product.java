 package Entity;
 import java.time.LocalDate;
 import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private String code;
	//private String image;
	private String name;
	private float price;
	private int qyt;
	private LocalDate date;
	//private String shop_id;
	
	public Product(){
		
	}
	
	public Product(String code,String name,float price,int qty){
		this.code=code;
		this.name=name;
		this.price=price;
		this.qyt=qty;
		this.date=LocalDate.now();
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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
	
	
	
	

}
