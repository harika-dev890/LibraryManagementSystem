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

import com.libraryManagementSystem.entity.Library;
import com.libraryManagementSystem.service.LibraryService;
import com.libraryManagementSystem.util.ResponseStructure;

@RestController
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	public LibraryService libraryService;
	@PostMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Library>> saveLibrary(@RequestBody Library library,@PathVariable int addressId){
		return libraryService.saveLibrary(library, addressId);
	}
	@GetMapping("/{libraryId}")
	public ResponseEntity<ResponseStructure<Library>> findId(@PathVariable int libraryId){
		return libraryService.findLibraryByID(libraryId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Library>>> findIdAll(){
		return libraryService.findAllId();
	}
	@PutMapping("/{libraryId}")
	public ResponseEntity<ResponseStructure<Library>> updateLibrary(@PathVariable int libraryId,@RequestBody Library library){
		return libraryService.updateLibrary(libraryId, library);
	}
	@DeleteMapping("/{libraryId}")
	public ResponseEntity<ResponseStructure<Library>> deleteLibrary(@PathVariable int libraryId){
		return libraryService.deleteLibrary(libraryId);
	}

}
