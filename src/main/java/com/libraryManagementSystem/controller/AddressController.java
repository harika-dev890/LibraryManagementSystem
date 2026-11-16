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

import com.libraryManagementSystem.entity.Address;
import com.libraryManagementSystem.service.AddressService;
import com.libraryManagementSystem.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address){
		return addressService.saveAddress(address);
		
	}
	@GetMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> findAddressById(@PathVariable int addressId){
		return addressService.findAddressByID(addressId);
		
	}
	@PutMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int addressId,@RequestBody Address address) {
	    address.setAddressId(addressId); 
	    return addressService.updateAddress(address);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress() {
	    return addressService.findAllAddress();
	}
	@DeleteMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>>deleteAddress(@PathVariable int addressId) {
	    return addressService.deleteAddress(addressId);
	}
	
	

}
