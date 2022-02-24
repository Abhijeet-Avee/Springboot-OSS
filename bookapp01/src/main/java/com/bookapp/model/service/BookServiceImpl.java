package com.bookapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.entities.Book;
import com.bookapp.model.exceptions.BookNotFoundException;
import com.bookapp.model.persistence.BookDao;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	public Book getBookById(int id) {
		return bookDao.findById(id).orElseThrow(()-> new BookNotFoundException("book with id: "+id + "not found"));
	}

	@Override
	public Book addBook(Book book) {
		return bookDao.save(book);
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		return bookDao.findByTitle(title);
	}

	@Override
	public Book updateBook(int bookId, Book book) {
		Book bookToUpdate = bookDao.getById(bookId);
		bookToUpdate.setPrice(book.getPrice());
		bookDao.save(bookToUpdate);
		return bookToUpdate;
	}

	@Override
	public Book deleteBook(int bookId) {
		Book bookToDelete = bookDao.getById(bookId);
		bookDao.delete(bookToDelete);
		return bookToDelete;
	}

	@Override
	public List<Book> getAll() {
		return bookDao.findAll();
	}

}
