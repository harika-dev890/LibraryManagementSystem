package com.libraryManagementSystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.BookDao;
import com.libraryManagementSystem.dao.LibraryDao;
import com.libraryManagementSystem.dao.UserDao;
import com.libraryManagementSystem.entity.Book;
import com.libraryManagementSystem.entity.Library;
import com.libraryManagementSystem.entity.User;
import com.libraryManagementSystem.util.ResponseStructure;

@Service
public class BookService {
	@Autowired
	public BookDao bookDao;	
	@Autowired
	public LibraryDao libraryDao;
	@Autowired
	public UserDao userDao;
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book){
		bookDao.saveBook(book);
		ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
		responseStructure.setData(book);
		responseStructure.setMessage("Book saved");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);	
	}
	public ResponseEntity<ResponseStructure<Book>> addBookToLibrary(int libraryId,int bookId){
		Library libraryById=libraryDao.findLibraryById(libraryId);
		List<Book> booksInLibrary=libraryById.getBooks();
		Book bookById=bookDao.findBookById(bookId);
		booksInLibrary.add(bookById);
		libraryDao.updateLibrary(libraryById);
		ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
		responseStructure.setMessage("book added to library");
		responseStructure.setData(bookById);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Book>> findBookById(int bookId){
		Book findBookId=bookDao.findBookById(bookId);
		ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
		if(findBookId!=null) {
			responseStructure.setData(findBookId);
			responseStructure.setMessage("Book found");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setData(findBookId);
			responseStructure.setMessage("Book not found");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	public ResponseEntity<ResponseStructure<List<Book>>> findAllBook(){
		List<Book> allBooks=bookDao.findAllBook();
		ResponseStructure<List<Book>> responseStructure=new ResponseStructure<List<Book>>();
		if(allBooks!=null) {
			responseStructure.setData(allBooks);
			responseStructure.setMessage("Books found");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setData(null);
			responseStructure.setMessage("Books not found");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	public ResponseEntity<ResponseStructure<Book>> updateBook(int bookId,Book book){
		Book existingBook=bookDao.findBookById(bookId);
		ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
		if(existingBook!=null) {
			
			existingBook.setAuthor(book.getAuthor());
			existingBook.setBorrowedTime(book.getBorrowedTime());
			existingBook.setTitle(book.getTitle());
			existingBook.setReturnedTime(book.getReturnedTime());
			existingBook.setUser(book.getUser());
			bookDao.updateBook(existingBook,bookId);
			responseStructure.setData(existingBook);
			responseStructure.setMessage("Book updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
	
		}
		else {
			responseStructure.setData(null);
			responseStructure.setMessage("Books not updated,book not found");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
		
	}
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int bookId){
		Book findId=bookDao.findBookById(bookId);
		ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
		if(findId!=null) {
			bookDao.deleteBook(bookId);
			responseStructure.setData(findId);
			responseStructure.setMessage("Book deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setData(null);
			responseStructure.setMessage("Books not deleted,book not found");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	public ResponseEntity<ResponseStructure<Book>> borrowBook(int bookId,int userId){
		User user=userDao.findUserById(userId);
		
		Book book=bookDao.findBookById(bookId);
		
		
		if(user!=null && book!=null && !book.isBorrowed()) {
			book.setBorrowed(true);
			book.setUser(user);
			book.setBorrowedTime(LocalDateTime.now());
			bookDao.updateBook(book,bookId);
			ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
			responseStructure.setData(book);
			responseStructure.setMessage("Book borrowed successfully");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);	
		}
		else {
			ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
			responseStructure.setData(null);
			responseStructure.setMessage("Books unable to borrow");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
		
	}
	public ResponseEntity<ResponseStructure<Book>> returnBook(int bookId,int userId){
		User user=userDao.findUserById(userId);
		Book book=bookDao.findBookById(bookId);
		if(user!=null && book!=null && book.isBorrowed()) {
			book.setBorrowed(false);
			book.setUser(null);
			book.setReturnedTime(LocalDateTime.now());
			bookDao.updateBook(book,bookId);
			ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
			responseStructure.setData(book);
			responseStructure.setMessage("Book returned successfully");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);	
		}
		else {
			ResponseStructure<Book> responseStructure=new ResponseStructure<Book>();
			responseStructure.setData(null);
			responseStructure.setMessage("Books unable to return");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}

	
	

}
