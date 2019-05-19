package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.*;
import com.example.demo.service.UserClientService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserClientService userClientService;
	
	
	
	@RequestMapping("/addorder")
	public String getAddOrder(@ModelAttribute User user) {
		return "addorder";
	}
	
	@GetMapping("/login")
	public String goLogin(@ModelAttribute User user) {
		
		return "login";
				
	}
	
	
	@PostMapping("/create")
	public String createUser(User user,Model model) {
		userClientService.createUser(user);
		model.addAttribute("user","Register SucessFully");
		return "login";
	}
	
	/*
	@GetMapping
	 @RequestMapping("/{id}")
    public String getById(@PathVariable String id, Model model){
        model.addAttribute("user", userClientService.findUserById(id));
        return "login";
    }
	*/
	
	
	//map edit user page
	@GetMapping("/edituser")
	public String findUser(@ModelAttribute User user) {
		
		return "edituser";
				
	}
	
	// find id from edit user page and return that to update user page with user object
	@PostMapping("/updateuser")
	public String findUserUpdate(@ModelAttribute User user, Model model) {
		
		User userone = userClientService.findUserById(user.getId());
		 model.addAttribute("user", userone);
		 
		 return "userupdate";
		
	}
	
	//getall All usrs 
	@GetMapping("/allusers")
    public String getAll(Model model){
        model.addAttribute("user", userClientService.getAllUsers());
        return "Allusers";
    }


	@GetMapping("/delete")
	public String godeleteUser(@ModelAttribute User user) {
		
		return "userdelete";
				
	}
	
	
	@PostMapping("/delete")
	public String deleteUser(@ModelAttribute User user) {
		
		userClientService.userDelete(user);
		return "userdelete";
	}
	
	@GetMapping("/error")
	public String error(@ModelAttribute User user) {
		
		return "error";
				
	}
	
	
	
	

		
	
	
	
	
}
