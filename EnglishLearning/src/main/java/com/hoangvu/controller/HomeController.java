package com.hoangvu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoangvu.entity.CustomUserDetails;
import com.hoangvu.entity.User;
import com.hoangvu.service.CategoryService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/home")
	public String home(ModelMap model,HttpServletRequest request) {	
		
		CustomUserDetails cus = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("avatar", cus.getAvatarName());
		
		request.getSession().setAttribute("avatar", cus.getAvatarName());
		model.addAttribute("categories", categoryService.categoryDTOs());
		
		return "home";
		}
	
	@RequestMapping("/add")
	public String add(ModelMap model,HttpServletRequest request) {	
		
		
		
		
		
		model.addAttribute("categories", categoryService.categoryDTOs());
		model.addAttribute("avatar", request.getSession().getAttribute("avatar"));
		
		return "add";
		}
}
