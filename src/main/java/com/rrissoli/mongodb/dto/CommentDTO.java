package com.rrissoli.mongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String texto;
	private Date data;
	private AuthorDTO author;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public CommentDTO(String texto, Date date, AuthorDTO author) {
		super();
		this.texto = texto;
		this.data = date;
		this.author = author;
	}
	
	
	
}
