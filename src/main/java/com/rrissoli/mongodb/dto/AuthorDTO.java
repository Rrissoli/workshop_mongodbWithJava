package com.rrissoli.mongodb.dto;

import java.io.Serializable;

import com.rrissoli.mongodb.domain.User;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;


	public AuthorDTO() {

	}

	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
