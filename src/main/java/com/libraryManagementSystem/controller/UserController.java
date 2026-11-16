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

import com.libraryManagementSystem.entity.User;
import com.libraryManagementSystem.service.UserService;
import com.libraryManagementSystem.util.ResponseStructure;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user,@PathVariable int addressId ){
		 return userService.saveUser(user, addressId);
		
	}
	@GetMapping("/{userId}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int  userId){
		return userService.findUserById(userId);
	}
	@PutMapping("/{userId}")
	public ResponseEntity<ResponseStructure<User>> updateUser(@PathVariable int userId,@RequestBody User user){
		 user.setUserId(userId); 
		return userService.updateUser(user);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
		return userService.findAllUser();
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable int  userId){
		return userService.deleteUser(userId);
	}
}
