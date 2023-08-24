package com.cg.electricitybilling.util;

import org.springframework.stereotype.Component;

import com.cg.electricitybilling.dto.UserDetail;
import com.cg.electricitybilling.entity.Customer;
import com.cg.electricitybilling.entity.User;

@Component
public class UserUtil {
	
	public UserDetail toDetails(Customer cust, User user) {
		UserDetail details=null;
		new UserDetail(cust.getUser_id(),user.getPassword(),user.getRole());
		return details;
	}

}
