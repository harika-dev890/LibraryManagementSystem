package com.libraryManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libraryManagementSystem.entity.User;
import com.libraryManagementSystem.repository.UserRepository;
@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}
	public User updateUser(User user) {
		userRepository.save(user);
		return user;
	}
	public User findUserById(int userId) {
		Optional<User> optional=userRepository.findById(userId);
		if (optional.isPresent())		
		return optional.get();
		return null;
	}
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
	public String deleteUser(int userId) {
		userRepository.deleteById(userId);
		return "User deleted";
	}

}
