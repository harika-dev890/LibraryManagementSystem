package com.libraryManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.AddressDao;
import com.libraryManagementSystem.dao.UserDao;
import com.libraryManagementSystem.entity.Address;
import com.libraryManagementSystem.entity.User;
import com.libraryManagementSystem.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user,int addressId){
		Address findAddressById =addressDao.findAddressById(addressId);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		if(findAddressById!=null) {
			user.setAddress(findAddressById);
			userDao.saveUser(user);
			responseStructure.setMessage("user saved successfully");
			responseStructure.setData(user);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("user not successfully,addressid not found");
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
			
		}
	}
	public ResponseEntity<ResponseStructure<User>> findUserById(int userId){
		User findUserById=userDao.findUserById(userId);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		if(findUserById!=null) {
			responseStructure.setData(findUserById);
			responseStructure.setMessage("user found");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setData(null);
			responseStructure.setMessage("user not found");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
		
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){
		User existingId=userDao.findUserById(user.getUserId());
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		if(existingId!=null) {
			existingId.setName(user.getName());
			existingId.setPhoneNumber(user.getPhoneNumber());
			existingId.setEmail(user.getEmail());
			responseStructure.setData(user);
			responseStructure.setMessage("user updated");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setData(null);
			responseStructure.setMessage("user not found");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
		}	
	}
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
		List<User> findAllUser=userDao.findAllUser();
		ResponseStructure<List<User>> responseStructure=new ResponseStructure<List<User>>();
		if(!findAllUser.isEmpty()) {
			responseStructure.setMessage("address found");
			responseStructure.setData(findAllUser);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			 return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("address not  found");
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			 return new ResponseEntity<ResponseStructure<List<User>>>(responseStructure, HttpStatus.BAD_REQUEST);
		}
	}
	public ResponseEntity<ResponseStructure<User>> deleteUser(int userId){
        User findUserById=userDao.findUserById(userId);
        ResponseStructure<User> responseStructure=new ResponseStructure<User>();
        if(findUserById!=null) {
        	userDao.deleteUser(userId);
        	responseStructure.setMessage("user deleted");
			responseStructure.setData(findUserById);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			 return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
        else {
        	
        	responseStructure.setMessage("user not exist");
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
        }
	}
        
}
