package com.libraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Integer> {

}
