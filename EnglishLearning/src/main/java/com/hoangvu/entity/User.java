package com.hoangvu.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
	private String avatarname;
	private boolean active;
	private boolean gender;
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	List<Role>roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarname() {
		return avatarname;
	}

	public void setAvatarname(String avatarname) {
		this.avatarname = avatarname;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User(long id, String username, String password, String avatarname, boolean active, boolean gender,
			String email, List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatarname = avatarname;
		this.active = active;
		this.gender = gender;
		this.email = email;
		this.roles = roles;
	}

	public User() {
		super();
	}
	
	
}
