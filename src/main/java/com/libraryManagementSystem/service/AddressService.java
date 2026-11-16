package com.libraryManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.AddressDao;
import com.libraryManagementSystem.entity.Address;
import com.libraryManagementSystem.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address){
		Address saveAddress=addressDao.saveAddress(address);
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		responseStructure.setMessage("Address saved");
		responseStructure.setData(saveAddress);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		
	}
	public ResponseEntity<ResponseStructure<Address>> findAddressByID(int addressId){
		Address findAddressByID=addressDao.findAddressById(addressId);
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		if(findAddressByID!=null) {
			responseStructure.setMessage("ID found");
			responseStructure.setData(findAddressByID);
			responseStructure.setStatusCode(HttpStatus.OK.value());	
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("ID  not found");
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.BAD_REQUEST);
		}	
	}
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address){
		Address existingAddress=addressDao.findAddressById(address.getAddressId());
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		if(existingAddress!=null) {
			existingAddress.setHouseNumber(address.getHouseNumber());
		    existingAddress.setArea(address.getArea());
		    existingAddress.setCity(address.getCity());
		    existingAddress.setState(address.getState());
		    existingAddress.setCountry(address.getCountry());
		    existingAddress.setPinCode(address.getPinCode());
			Address updateAddress=addressDao.updateAddress(existingAddress);
			responseStructure.setMessage("Address updated");
			responseStructure.setData(updateAddress);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("Address not found");
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.BAD_REQUEST);
		}	
	}
	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress() {
	    List<Address> findAllAddress = addressDao.findAllAddress();
	    ResponseStructure<List<Address>> responseStructure = new ResponseStructure<>();

	    if (!findAllAddress.isEmpty()) {
	        responseStructure.setMessage("Addresses found");
	        responseStructure.setData(findAllAddress);
	        responseStructure.setStatusCode(HttpStatus.OK.value());
	        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	    } else {
	        responseStructure.setMessage("No addresses found");
	        responseStructure.setData(null);
	        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value()); 
	        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	    }
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int addressId){
		Address deleteAddress=addressDao.findAddressById(addressId);
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		if(deleteAddress!=null) {
			addressDao.deleteAddress(addressId);
			responseStructure.setMessage("Address deleted");
			responseStructure.setData(deleteAddress);
			responseStructure.setStatusCode(HttpStatus.OK.value());	
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else {
			responseStructure.setMessage("Id not found");
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());	
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
		
	}
	

}
