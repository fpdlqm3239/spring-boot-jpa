package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;

@RestController
public class CustomerController {
	private CustomerDAO customerDAO;
	
	public CustomerController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	
	@PutMapping("/customer")
	public Customer putCustomer(Customer customer) {
		
		return customerDAO.save(customer);
	}
	
	@PostMapping("/customer")
	public Customer postCustomer(Customer customer) {
		
		return customerDAO.save(customer);
	}
	
	@DeleteMapping("/customer")
	public void deleteCustomer(int id) {
		
		if(customerDAO.findById(id).orElse(null) != null){
			customerDAO.deleteById(id);
		}
	}
	
	@GetMapping("/customer")
	public Customer getCustomer(int id) {
		
		return customerDAO.findById(id).orElse(null);
	}
	
	@GetMapping("/customer/name")
	public List<Customer> getCustomer(String name) {
		
		return customerDAO.findByName(name);
	}
	
	@GetMapping("/customer/search")
	public List<Customer> getCustomerLike(String name) {
		
		return customerDAO.findByNameLike("%"+name+"%");
	}
	
	@GetMapping("/customer/or")
	public List<Customer> getCustomerLike2(String name, String address) {
		
		return customerDAO.findByNameOrAddress(name, address);
	}
	
	@GetMapping("/customer/and")
	public List<Customer> getCustomerLike3(String name, String address) {
		
		return customerDAO.findByNameAndAddress(name, address);
	}
	
	@GetMapping("/customer/vip")
	public List<Customer> getCustomerLike4(String name, String address) {
		
		return customerDAO.findVippList(name, address);
	}
	
	@GetMapping("/customer/list")
		public List<Customer> getCustomerList() {
			
			return (List<Customer>)customerDAO.findAll();
		}
	
	
	
}
