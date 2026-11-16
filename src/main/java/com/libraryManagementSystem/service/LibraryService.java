package com.libraryManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.AddressDao;
import com.libraryManagementSystem.dao.LibraryDao;
import com.libraryManagementSystem.entity.Address;
import com.libraryManagementSystem.entity.Library;
import com.libraryManagementSystem.util.ResponseStructure;
@Service
public class LibraryService {
	@Autowired
	private LibraryDao libraryDao;
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Library>> saveLibrary(Library library,int addressId){
		Address findAddressById=addressDao.findAddressById(addressId);
	    ResponseStructure<Library> responseStructure=new ResponseStructure<Library>();
	    if(findAddressById!=null) {
	    	library.setAddress(findAddressById);
	    	libraryDao.saveLibrary(library);
	    	responseStructure.setData(library);
	    	responseStructure.setMessage("library saved");
	    	responseStructure.setStatusCode(HttpStatus.OK.value());
	    	return new ResponseEntity<ResponseStructure<Library>>(responseStructure,HttpStatus.OK);	
	    }
	    else {
	    	responseStructure.setData(null);
	    	responseStructure.setMessage("address id not exist");
	    	responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
	    	return new ResponseEntity<ResponseStructure<Library>>(responseStructure,HttpStatus.BAD_REQUEST);	
	    }
		
	}
	 public ResponseEntity<ResponseStructure<Library>> findLibraryByID(int libraryId){
		Library finLibrary=libraryDao.findLibraryById(libraryId);
		ResponseStructure<Library> responseStructure=new ResponseStructure<Library>();
		if(finLibrary!=null) {
			responseStructure.setMessage("library found");
			responseStructure.setData(finLibrary);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Library>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("library not found");
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Library>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	 public ResponseEntity<ResponseStructure<List<Library>>> findAllId(){
	     List<Library>	findAll= libraryDao.findAllLibrary(); 
	     ResponseStructure<List<Library>> responseStructure=new ResponseStructure<List<Library>>();
	     if(!findAll.isEmpty()) {
	    	 responseStructure.setMessage("Libraries found");
	    	 responseStructure.setData(findAll);
	    	 responseStructure.setStatusCode(HttpStatus.OK.value());
	    	 return new ResponseEntity<ResponseStructure<List<Library>>>(responseStructure,HttpStatus.OK);
	     }
	     else {
	    	 responseStructure.setMessage("Libraries not found");
	    	 responseStructure.setData(null);
	    	 responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
	    	 return new ResponseEntity<ResponseStructure<List<Library>>>(responseStructure,HttpStatus.BAD_REQUEST);
	     }
	 }
	 public ResponseEntity<ResponseStructure<Library>> updateLibrary(int libraryId,Library library){
		Library updatedLibrary= libraryDao.findLibraryById(libraryId);
		ResponseStructure<Library> responseStructure=new ResponseStructure<Library>();
		if(updatedLibrary!=null) {
			updatedLibrary.setLibraryId(library.getLibraryId());
			updatedLibrary.setName(library.getName());
			updatedLibrary.setPhoneNumber(library.getPhoneNumber());
			updatedLibrary.setAddress(library.getAddress());
			updatedLibrary.setBooks(library.getBooks());
			libraryDao.saveLibrary(updatedLibrary);
			responseStructure.setMessage("Library Updated");
			responseStructure.setData(updatedLibrary);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new  ResponseEntity<ResponseStructure<Library>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("Library not Updated");
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new  ResponseEntity<ResponseStructure<Library>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	 }
	 public ResponseEntity<ResponseStructure<Library>> deleteLibrary(int libraryId){
		 Library deletedLibrary=libraryDao.findLibraryById(libraryId);
		 ResponseStructure<Library>  responseStructure=new ResponseStructure<Library>();
		 if(deletedLibrary!=null) {
			 libraryDao.deleteLibrary(libraryId);
			 responseStructure.setMessage("library deleted");
			 responseStructure.setData(deletedLibrary);
			 responseStructure.setStatusCode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<Library>>(responseStructure,HttpStatus.OK);
		 }
		 else {
			 responseStructure.setMessage("Library not deleted,id not exist");
				responseStructure.setData(null);
				responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
				return new  ResponseEntity<ResponseStructure<Library>>(responseStructure,HttpStatus.BAD_REQUEST);
		 }
	 }

}
