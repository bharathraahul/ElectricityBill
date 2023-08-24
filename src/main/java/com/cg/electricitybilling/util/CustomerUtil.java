package com.cg.electricitybilling.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cg.electricitybilling.dto.CustomerDetail;
import com.cg.electricitybilling.entity.Customer;

@Component
public class CustomerUtil {
	
	public CustomerDetail toDetails(Customer cust) {
		CustomerDetail details=null;
		details=new CustomerDetail(cust.getUser_id(),cust.getUser_id(), cust.getName(), cust.getAddress(), cust.getPhone(), cust.getMeter_id(), cust.getEmail(),cust.getPassword());
		return details;
	}
	
	public List<CustomerDetail> toDetails(List<Customer> custList) {
		List<CustomerDetail> details = new ArrayList<>();
		for (Customer customer : custList) {
			CustomerDetail c = toDetails(customer);
			details.add(c);
		}		
		return details;
	}

	
}
