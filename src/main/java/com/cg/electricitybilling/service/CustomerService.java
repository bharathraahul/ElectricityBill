package com.cg.electricitybilling.service;

import java.util.List;
import java.util.Optional;

import com.cg.electricitybilling.entity.Customer;



public interface CustomerService {
	Customer add(Customer cust);

	List<Customer> findAll();

	Customer findbyId(Integer cust_id);

	String deleteCustomer(Integer cust_id);

}
