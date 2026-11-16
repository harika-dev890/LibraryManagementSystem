package com.libraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
