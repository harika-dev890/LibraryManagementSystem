package com.libraryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagementSystem.entity.Book;
import com.libraryManagementSystem.service.BookService;
import com.libraryManagementSystem.util.ResponseStructure;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	public BookService bookSerivce;
	@PostMapping
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book){
		return bookSerivce.saveBook(book);
	}
	@PutMapping("/{bookId}/{libraryId}")
	public ResponseEntity<ResponseStructure<Book>> addBookToLibrary(@PathVariable int bookId,@PathVariable int libraryId){
		return bookSerivce.addBookToLibrary(libraryId, bookId);
	}
	@GetMapping("/{bookId}")
	public ResponseEntity<ResponseStructure<Book>> findBookById(@PathVariable int bookId){
		return bookSerivce.findBookById(bookId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Book>>> findAllBook(){
		return bookSerivce.findAllBook();
	}
	@PutMapping("/{bookId}")
	public ResponseEntity<ResponseStructure<Book>> updateBook(@PathVariable int bookId,@RequestBody Book book){
		return bookSerivce.updateBook(bookId,book);
	}
	@DeleteMapping("/{bookId}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable int bookId){
		return bookSerivce.deleteBook(bookId);
	}
	@PutMapping("/borrow/{bookId}/{userId}")
	public ResponseEntity<ResponseStructure<Book>> borrowBook(@PathVariable int bookId,@PathVariable int userId){
		return bookSerivce.borrowBook(bookId, userId);
	}
	@PutMapping("/return/{bookId}/{userId}")
	public ResponseEntity<ResponseStructure<Book>> returnBook(@PathVariable int bookId,@PathVariable int userId){
		return bookSerivce.returnBook(bookId, userId);
	}
}
