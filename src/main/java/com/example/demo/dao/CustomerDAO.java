package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {
	List<Customer> findByName(String name);
	List<Customer> findByNameLike(String name);
	List<Customer> findByNameOrAddress(String name, String address);
	List<Customer> findByNameAndAddress(String name, String address);
	
	@Query("from Customer where name =?1 and address = ?2")
	List<Customer> findVippList(String value1, String value2);
}
