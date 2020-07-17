package com.hoangvu.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.Parameter;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoangvu.entity.CustomUserDetails;

@Controller
public class MainController {
	
	@RequestMapping(value = "/test")
	public String main(@RequestParam(name = "q")String category,ModelMap model,HttpServletRequest request) {
		request.getSession().setAttribute("category", category);
		model.addAttribute("avatar", request.getSession().getAttribute("avatar"));
		model.addAttribute("category", category);
		
		return "dashboard";
	}
}
