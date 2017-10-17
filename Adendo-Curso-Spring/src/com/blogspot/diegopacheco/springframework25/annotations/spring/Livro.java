package com.blogspot.diegopacheco.springframework25.annotations.spring;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Livro {
	
	private String isbn;
	private String titulo;
	
	public Livro() {
		isbn = "10ergregKL2";
		titulo = "O código de Da vince";
	}

	public String getIsbn() {
		return isbn;
	}
	
	@Required
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
	
	@Override
	public String toString() {
		return "[livro={isbn: " + isbn + ",titulo: " + titulo + "}]";
	}
	
}
