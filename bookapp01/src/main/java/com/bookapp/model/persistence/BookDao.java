package com.bookapp.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.entities.Book;

//-----Spring data -----//
@Repository
public interface BookDao extends JpaRepository<Book, Integer>{
	
	public List<Book> findByTitle(String title);
	public Book findByAuthor(String author);
	
}
