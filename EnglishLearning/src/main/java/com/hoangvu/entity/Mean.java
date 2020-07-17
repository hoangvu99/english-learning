package com.hoangvu.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="mean")
public class Mean {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "means")
	List<Vocabulary>vocabularies;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	Category category;

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

	public List<Vocabulary> getVocabularies() {
		return vocabularies;
	}

	public void setVocabularies(List<Vocabulary> vocabularies) {
		this.vocabularies = vocabularies;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Mean(long id, String name, List<Vocabulary> vocabularies, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.vocabularies = vocabularies;
		this.category = category;
	}

	public Mean() {
		super();
	}
	
	
	
}
