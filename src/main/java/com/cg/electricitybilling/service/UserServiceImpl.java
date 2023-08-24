package com.cg.electricitybilling.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.electricitybilling.dao.UserDao;
import com.cg.electricitybilling.dto.CreateCustomerRequest;
import com.cg.electricitybilling.dto.CustomerDetail;
import com.cg.electricitybilling.entity.Customer;
import com.cg.electricitybilling.entity.User;
import com.cg.electricitybilling.exception.AuthenticationFailedException;
import com.cg.electricitybilling.exception.UserNotFoundException;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao uDao;

	@Override
	public String login(User user) {
		Optional<User> opt = uDao.findById(user.getUser_id());
		if(!opt.isPresent()) {			
			 throw new UserNotFoundException("User not found with userid: "
			         +user.getUser_id());
		}
		User uDetails = opt.get();
		if(!uDetails.getPassword().equals(user.getPassword())) {
			throw new AuthenticationFailedException("Authentication failed for userids: "
			         +user.getUser_id());
		}
		if(!uDetails.getRole().equals(user.getRole())) {
			throw new AuthenticationFailedException("role not found for id: "
			         +user.getUser_id());
		}
		return uDetails.getRole();
	}

	@Override
	public User add(CustomerDetail custdetail,User user) {
		User u= new User(user.getUser_id(),custdetail.getName(),custdetail.getPassword(),user.getRole());
		User user1=uDao.save(u);
          return user1;
	}
}
