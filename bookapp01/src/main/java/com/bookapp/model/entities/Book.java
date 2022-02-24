package com.bookapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="book_table")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Double price;
	private String author;
	public Book(String title, Double price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}
	public Book() {
	}
	
	
}
