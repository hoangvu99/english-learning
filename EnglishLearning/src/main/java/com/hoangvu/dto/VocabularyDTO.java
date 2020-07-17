package com.hoangvu.dto;

import java.util.List;


public class VocabularyDTO {
	
	private long id;
	private String name;		
	List<MeanDTO>meanDTOs;		
	CategoryDTO category;
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
	public List<MeanDTO> getMeanDTOs() {
		return meanDTOs;
	}
	public void setMeanDTOs(List<MeanDTO> meanDTOs) {
		this.meanDTOs = meanDTOs;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	public VocabularyDTO(long id, String name, List<MeanDTO> meanDTOs, CategoryDTO category) {
		super();
		this.id = id;
		this.name = name;
		this.meanDTOs = meanDTOs;
		this.category = category;
	}
	public VocabularyDTO() {
		super();
	}
	
}
