package com.hoangvu.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoangvu.dto.CategoryDTO;
import com.hoangvu.service.CategoryService;
import com.hoangvu.service.VocabularyService;

@RestController
@RequestMapping(value="/api")
public class MainRestController {
	
	@Autowired
	VocabularyService vocabularyService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/getQuestion")
	public String[] getQuestion(HttpServletRequest request){
		String category = (String) request.getSession().getAttribute("category");
		CategoryDTO categoryDTO = categoryService.getCategoryId(category);
		String []arr = vocabularyService.createQuestion(categoryDTO.getId());
		
		return arr;
	}
	
	@RequestMapping(value="/sleep")
	public void sleep() {	
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
