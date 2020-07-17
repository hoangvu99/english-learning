package com.hoangvu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoangvu.dao.RoleRepository;
import com.hoangvu.dao.UserRepository;
import com.hoangvu.entity.Role;
import com.hoangvu.entity.User;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping("/login")
	public String login() {	
		
		
		
		return "login";
	}
	
	
	
}
