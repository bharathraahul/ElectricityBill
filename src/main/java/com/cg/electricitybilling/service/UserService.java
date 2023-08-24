package com.cg.electricitybilling.service;

import com.cg.electricitybilling.dto.CreateCustomerRequest;
import com.cg.electricitybilling.dto.CustomerDetail;
import com.cg.electricitybilling.entity.Customer;
import com.cg.electricitybilling.entity.User;

public interface UserService {
	String login(User user);

	User add(CustomerDetail custDetail, User user);

}
