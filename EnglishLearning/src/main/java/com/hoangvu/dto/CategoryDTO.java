package com.hoangvu.dto;

import java.util.List;

import com.hoangvu.entity.Mean;



public class CategoryDTO {
	
	private long id;
	private String name;				
	CategoryDTO categoryDTO;
	List<MeanDTO>meanDTOs;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	public List<MeanDTO> getMeanDTOs() {
		return meanDTOs;
	}
	public void setMeanDTOs(List<MeanDTO> meanDTOs) {
		this.meanDTOs = meanDTOs;
	}
	public CategoryDTO(long id, String name, CategoryDTO categoryDTO, List<MeanDTO> meanDTOs) {
		super();
		this.id = id;
		this.name = name;
		this.categoryDTO = categoryDTO;
		this.meanDTOs = meanDTOs;
	}
	public CategoryDTO() {
		super();
	}
	
}
