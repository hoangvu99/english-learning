package com.hoangvu.service;

import java.util.List;

import com.hoangvu.dto.CategoryDTO;

public interface CategoryService {
		
	public String addCategory(CategoryDTO categoryDTO);
	
	public List<CategoryDTO>categoryDTOs();
	
	public CategoryDTO getCategoryId(String category);

	
	
}
