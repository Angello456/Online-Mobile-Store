package com.example.demo.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.*;


@Service
public class UserClientService {
	
	public List<User> getAllUsers(){
		RestTemplate restTemplate = new RestTemplate();
		List<User> user = restTemplate.getForObject("http://localhost:8085/PAF/user_managment/users",List.class);
		return user;
	}
	
	
	public void createUser(User user) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForLocation("http://localhost:8085/PAF/user_managment/users",user,User.class);
	}
	
    public User findUserById(long id){
    	RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8085/PAF/user_managment/users/"+id, User.class);
    }
    
    public void  userDelete(User user){
    	Map<String,Long> params = new HashMap<String ,Long>();
    	params.put("id", user.getId());
    	
    	RestTemplate restTemplate = new RestTemplate();
		 
		 restTemplate.delete("http://localhost:8085/PAF/user_managment/user/{id}",params);
    }
}

	
    


