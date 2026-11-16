package com.libraryManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libraryManagementSystem.entity.Library;
import com.libraryManagementSystem.repository.LibraryRepository;

@Repository
public class LibraryDao {
	
	
		@Autowired
		private LibraryRepository libraryRepository;
		
		public Library saveLibrary(Library library) {
			libraryRepository.save(library);
			return library;
		}
		public Library updateLibrary(Library library) {
			libraryRepository.save(library);
			return library;
		}
		public Library findLibraryById(int libraryId) {
			Optional<Library> optional=libraryRepository.findById(libraryId);
			if (optional.isPresent())		
			return optional.get();
			return null;
		}
		public List<Library> findAllLibrary(){
			return libraryRepository.findAll();
		}
		public String deleteLibrary(int libraryId) {
			libraryRepository.deleteById(libraryId);
			return "Library deleted";
		}

	


}
