package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.entities.Book;
import com.bookapp.model.service.BookService;

@SpringBootApplication
public class Bookapp01Application implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(Bookapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookService.addBook(new Book("rich dad poor dad", 230.00, "RK"));
		bookService.addBook(new Book("thinking in java", 800.00, "foo"));
		System.out.println("------book is added....");
	}

}
