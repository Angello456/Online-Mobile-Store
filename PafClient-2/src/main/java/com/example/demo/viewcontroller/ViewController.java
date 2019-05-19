package com.example.demo.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.model.*;

@Controller
@RequestMapping("/user")
public class ViewController {
	
	@RequestMapping("/newuser")
	public String registerNewUser(@ModelAttribute User user) {
		
		return "usrRegister";
				
	}
	

	
	
	
	
	

}
