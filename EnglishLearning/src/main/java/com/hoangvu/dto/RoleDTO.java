package com.hoangvu.dto;

import java.util.List;




public class RoleDTO {
	
	
	private long id;
	private String name;
	
	
	List<UserDTO>usersDtos;


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


	public List<UserDTO> getUsersDtos() {
		return usersDtos;
	}


	public void setUsersDtos(List<UserDTO> usersDtos) {
		this.usersDtos = usersDtos;
	}


	public RoleDTO() {
		super();
	}


	public RoleDTO(long id, String name, List<UserDTO> usersDtos) {
		super();
		this.id = id;
		this.name = name;
		this.usersDtos = usersDtos;
	}
	
	
}
