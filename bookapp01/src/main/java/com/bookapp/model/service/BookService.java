package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.entities.Book;

public interface BookService {

	public Book getBookById(int id);
    public Book addBook(Book book);
    public List<Book> getBookByTitle(String title);
    public Book updateBook(int bookId, Book book);
    public Book deleteBook(int bookId);
	public List<Book> getAll();
}
