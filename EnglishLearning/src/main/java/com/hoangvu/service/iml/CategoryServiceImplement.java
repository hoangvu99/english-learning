package com.hoangvu.service.iml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoangvu.dao.CategoryRepository;
import com.hoangvu.dto.CategoryDTO;
import com.hoangvu.entity.Category;
import com.hoangvu.entity.Vocabulary;
import com.hoangvu.service.CategoryService;

@Service
public class CategoryServiceImplement implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public String addCategory(CategoryDTO categoryDTO) {
		if(categoryRepository.existsById(categoryDTO.getId())) {
			Category category = new Category();
			category.setName(categoryDTO.getName());
			categoryRepository.save(category);
			return "Add success";
		}
		
		return "Add failure";
	}

	@Override
	public List<CategoryDTO> categoryDTOs() {
		List<Category>categories = categoryRepository.findAll();
		List<CategoryDTO>categoryDTOs = new ArrayList<CategoryDTO>();
		
		for(Category category :  categories) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getName());
			categoryDTOs.add(categoryDTO);
			
		}
		return categoryDTOs;
	}

	@Override
	public CategoryDTO getCategoryId(String categoryname) {
		Category category= categoryRepository.loadCategoryByName(categoryname);
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}
		
}
