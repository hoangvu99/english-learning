package com.hoangvu.dto;

import java.util.List;

import com.hoangvu.entity.Role;

public class UserDTO {
	
	private long id;
	private String username;
	private String password;
	private String avatarname;
	private boolean active;
	private boolean gender;
	private String email;
	List<RoleDTO>roleDTOs;
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
	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}
	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}
	public UserDTO(long id, String username, String password, String avatarname, boolean active, boolean gender,
			String email, List<RoleDTO> roleDTOs) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatarname = avatarname;
		this.active = active;
		this.gender = gender;
		this.email = email;
		this.roleDTOs = roleDTOs;
	}
	public UserDTO() {
		super();
	}
	
}
