package com.libraryManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
