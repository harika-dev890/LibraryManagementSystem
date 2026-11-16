package com.libraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
