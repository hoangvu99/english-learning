package com.hoangvu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	List<User>users;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role(long id, String name, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public Role() {
		super();
	}
	
	
}
