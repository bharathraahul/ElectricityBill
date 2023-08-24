package com.cg.electricitybilling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.electricitybilling.dao.CustomerDao;
import com.cg.electricitybilling.entity.Customer;
import com.cg.electricitybilling.exception.UserNotFoundException;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao cDao;

	@Override
	public Customer add(Customer cust) {
		Customer customer=cDao.save(cust);
        return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> custList = cDao.findAll();
		return custList;
	}

	@Override
	public Customer findbyId(Integer cust_id) {
		Optional<Customer> cust= cDao.findById(cust_id);
		Customer cust1=cust.get();
		return cust1;
	}

	@Override
	public String deleteCustomer(Integer cust_id) {
		Optional <Customer> opt=cDao.findById(cust_id);
		if(!opt.isPresent())
		{
			throw new UserNotFoundException("Invalid customer id");
		}
		Customer cust=opt.get();
		cDao.deleteById(cust_id);
		return ("Deleted Customer with id"+cust_id);
	}

}
