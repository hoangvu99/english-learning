package com.hoangvu.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "vocabulary_mean",joinColumns = @JoinColumn(name="vocabulary_id"),
	inverseJoinColumns = @JoinColumn(name="mean_id"))
	List<Mean>means;
	
	@ManyToOne
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

	public List<Mean> getMeans() {
		return means;
	}

	public void setMeans(List<Mean> means) {
		this.means = means;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Vocabulary(long id, String name, List<Mean> means, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.means = means;
		this.category = category;
	}

	public Vocabulary() {
		super();
	}
	
	
	
	
}
