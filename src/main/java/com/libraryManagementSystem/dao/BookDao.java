package com.libraryManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libraryManagementSystem.entity.Book;
import com.libraryManagementSystem.repository.BookRepository;
@Repository
public class BookDao {
	@Autowired
	private BookRepository bookRepository;
	
	public Book saveBook(Book book) {
		bookRepository.save(book);
		return book;
	}
	public Book updateBook(Book book,int bookId) {
		Optional<Book> findById=bookRepository.findById(bookId);
		if(findById.isPresent()) {
			book.setBookid(book.getBookid());
			bookRepository.save(findById.get());
		}
      
		
		return findById.get();
	}
	public Book findBookById(int bookId) {
		Optional<Book> optional=bookRepository.findById(bookId);
		if(optional.isPresent()) 
		    return optional.get();
		return null;
		
//		return optional.orElse(null);
	}
	
	public List<Book> findAllBook(){
		return bookRepository.findAll();
	}
	public String deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
		return "Book deleted";
	}

}
