package com.placeorderservice.placeorder.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.placeorderservice.placeorder.model.Order;

@Service
public class RestClientService {

	
	//define a RestTemplate object
    private final RestTemplate restTemplate;

    private final String GET_ALL_URL = "http://localhost:8083/api/all";
    private final String GET_URL_BY_ID = "http://localhost:8083/api/order/";
    private final String GET_URL_DELETE = "http://localhost:8083/api/orders/{orderId}";

  //define an argument constructor, pass in the RestTemplate object
    //and Autowire it
    @Autowired
    public RestClientService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    
    
    /**
     * Get all Orders
     * @return a list
     */
    public List<Order> findAllOrders(){
        return Arrays.stream(restTemplate.getForObject(GET_ALL_URL,Order[].class)).collect(Collectors.toList());
    }

    public Order findOrderById(String id){
        return restTemplate.getForObject(GET_URL_BY_ID +id, Order.class);
    }

	/*public void deleteOrder(Long id) {
		restTemplate.delete(GET_URL_DELETE, HttpMethod.DELETE,Void.class, id); 
		
	}*/
    
    /*public void deleteOrder(Order del) {
    	Map<String,Long> params = new HashMap<String, Long>();
    	params.put("orderId", del.getOrderId());
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	restTemplate.delete("http://localhost:8081/api/orders/{orderId}",params);
    }*/


	
   
  
}
