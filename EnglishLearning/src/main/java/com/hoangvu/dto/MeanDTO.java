package com.hoangvu.dto;

import java.util.List;



public class MeanDTO {
	private long id;
	private String name;		
	List<VocabularyDTO>vocabulariDtos;		
	CategoryDTO categoryDTO;
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
	public List<VocabularyDTO> getVocabulariDtos() {
		return vocabulariDtos;
	}
	public void setVocabulariDtos(List<VocabularyDTO> vocabulariDtos) {
		this.vocabulariDtos = vocabulariDtos;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	public MeanDTO(long id, String name, List<VocabularyDTO> vocabulariDtos, CategoryDTO categoryDTO) {
		super();
		this.id = id;
		this.name = name;
		this.vocabulariDtos = vocabulariDtos;
		this.categoryDTO = categoryDTO;
	}
	public MeanDTO() {
		super();
	}
	
}
