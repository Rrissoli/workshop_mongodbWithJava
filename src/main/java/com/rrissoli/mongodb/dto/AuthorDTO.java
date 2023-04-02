package com.rrissoli.mongodb.dto;

import java.io.Serializable;

import com.rrissoli.mongodb.domain.User;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	public AuthorDTO() {

	}

	public AuthorDTO(User obj) {
		
		name = obj.getName();
		email = obj.getEmail();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
