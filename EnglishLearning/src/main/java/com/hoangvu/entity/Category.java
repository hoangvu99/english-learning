package com.hoangvu.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Vocabulary>vocabularies;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Mean>means;

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

	public List<Mean> getMeans() {
		return means;
	}

	public void setMeans(List<Mean> means) {
		this.means = means;
	}

	public Category(long id, String name, List<Vocabulary> vocabularies, List<Mean> means) {
		super();
		this.id = id;
		this.name = name;
		this.vocabularies = vocabularies;
		this.means = means;
	}

	public Category() {
		super();
	}
	
	
	
	
}
