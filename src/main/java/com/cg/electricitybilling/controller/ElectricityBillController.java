package com.cg.electricitybilling.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cg.electricitybilling.dto.BillDetails;
import com.cg.electricitybilling.dto.CreateCustomerRequest;
import com.cg.electricitybilling.dto.CustomerDetail;
import com.cg.electricitybilling.dto.UserDetail;
import com.cg.electricitybilling.dto.UserDto;
import com.cg.electricitybilling.entity.Bill;
import com.cg.electricitybilling.entity.Customer;
import com.cg.electricitybilling.entity.User;
import com.cg.electricitybilling.exception.UserNotFoundException;
import com.cg.electricitybilling.service.BillService;
import com.cg.electricitybilling.service.CustomerService;
import com.cg.electricitybilling.service.UserService;
import com.cg.electricitybilling.util.BillUtil;
import com.cg.electricitybilling.util.CustomerUtil;
import com.cg.electricitybilling.util.UserUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@CrossOrigin(origins="*" )
@RestController
@RequestMapping("/ebilling/")
public class ElectricityBillController {
	
	@Autowired
	private UserService uservice;
	
	@Autowired
	private CustomerService cservice;
@Autowired
private CustomerUtil customerUtil;

@Autowired
private BillService bservice;
@Autowired
private BillUtil billUtil;

@Autowired
private UserUtil userUtil;
	
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	@PostMapping("/login")
//	public String login(User user, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		String role = uservice.login(user);
//		session.setAttribute("user", user.getUser_id());
//		session.setAttribute("role", role);
//		return "You have successfully logged in as: "+role;
//	}
//	
@ResponseStatus(HttpStatus.ACCEPTED)
@PostMapping("/login")
public String login(@RequestBody UserDto userrequest, HttpServletRequest request) {
   HttpSession session = request.getSession();
	User user=new User(userrequest.getUser_id(),userrequest.getUser_name(),userrequest.getPassword(),userrequest.getRole());
	String role = uservice.login(user);
   session.setAttribute("user", user.getUser_id());
	session.setAttribute("role", role);
	return "You have successfully logged in as: "+role;
}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/logout")
	public String logout(User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("user");
		String role = (String) session.getAttribute("role");
		if(user.getRole().equals(role)) {
			session.invalidate();
			return "You have successfully logged out";
		}
		return "You are not logged in";
	}
	
	@PostMapping("/signup")
	public CustomerDetail add(@RequestBody CreateCustomerRequest requestData) {
	System.out.println("Request data"+requestData);
    	CustomerDetail custDetail=null;
    	UserDetail userDetail=null;
		Customer cust=new Customer(requestData.getUser_id(), requestData.getName(), requestData.getAddress(), requestData.getPhone(), requestData.getMeter_id(),
				requestData.getEmail(),requestData.getPassword());
		User user= new User(requestData.getUser_id(),requestData.getPassword(),"Customer");
		Customer customer=cservice.add(cust);
		custDetail=customerUtil.toDetails(customer);
		User user1= uservice.add(custDetail,user);
		userDetail= userUtil.toDetails(customer,user1);
		return custDetail;

}

	
	@GetMapping("/admin/viewAllCustomers")
	public List<CustomerDetail> findAllCustomers(HttpServletRequest request){
		HttpSession session = request.getSession();
		Object uid = session.getAttribute("user");
		if(uid==null) {
			throw new UserNotFoundException("You are not logged in");
		}
		String urole=(String) session.getAttribute("role");
		if(!urole.equalsIgnoreCase("Admin")) {
			throw new UserNotFoundException("You are not eligible to view the customers");
		}
		List<Customer> custList = cservice.findAll();
		List<CustomerDetail> details = customerUtil.toDetails(custList);
		return details;
	}
	
	@PostMapping("/viewCustomerById/{cust_id}")
	public CustomerDetail findCustomer(@PathVariable("cust_id") Integer cust_id, HttpServletRequest request){
		HttpSession session = request.getSession();
		Object uid = session.getAttribute("user");
		if(uid==null) {
			throw new UserNotFoundException("You are not logged in");
		}
		
		Customer cust= cservice.findbyId(cust_id);
		CustomerDetail details= customerUtil.toDetails(cust);
		return details;
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/admin/deleteCustomer/{cust_id}")
	public String deleteCustomer(@PathVariable("cust_id") Integer cust_id,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Object uid = session.getAttribute("user");
		if(uid==null) {
			throw new UserNotFoundException("You are not logged in");
		}
		String urole=(String) session.getAttribute("role");
		if(!urole.equalsIgnoreCase("Admin")) {
			throw new UserNotFoundException("You are not eligible to delete the customers");
		}
		String m=cservice.deleteCustomer(cust_id);
		return m;
	}
     
	
	@GetMapping("/admin/viewAllBills")
	public List<BillDetails> findAllBills(HttpServletRequest request){
		HttpSession session = request.getSession();
		Object uid = session.getAttribute("user");
		if(uid==null) {
			throw new UserNotFoundException("You are not logged in");
		}
		String urole=(String) session.getAttribute("role");
		if(!urole.equalsIgnoreCase("Admin")) {
			throw new UserNotFoundException("You are not eligible to view the bills");
		}
		List<Bill> bills = bservice.findAll();
		List<BillDetails> details = billUtil.toDetails(bills);
		return details;
	}
	
	@PostMapping("/viewBillById/{bill_id}")
	public BillDetails findBill(@PathVariable("bill_id") Integer bill_id, HttpServletRequest request){
		HttpSession session = request.getSession();
		Object uid = session.getAttribute("user");
		if(uid==null) {
			throw new UserNotFoundException("You are not logged in");
		}
		
		Bill bill= bservice.findbyId(bill_id);
		BillDetails details= billUtil.toDetails(bill);
		return details;
	}
	
	@PutMapping("/admin/deleteBill/{bill_id}")
	public String deleteBill(@PathVariable("bill_id") Integer bill_id,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Object uid = session.getAttribute("user");
		if(uid==null) {
			throw new UserNotFoundException("You are not logged in");
		}
		String urole=(String) session.getAttribute("role");
		if(!urole.equalsIgnoreCase("Admin")) {
			throw new UserNotFoundException("You are not eligible to delete the bills");
		}
		String m=bservice.deleteBill(bill_id);
		return m;
	}
	@PostMapping("/admin/genetateBill/{cust_id}/{consumed_units}/{consumer_no}")
	public Integer generateBill(@PathVariable("cust_id") Integer cust_id,@PathVariable("consumed_units") Integer consumed_units,@PathVariable("consumer_no") Integer consumer_no,HttpServletRequest request ) {
		HttpSession session = request.getSession();
		Object uid = session.getAttribute("user");
		if(uid==null) {
			throw new UserNotFoundException("You are not logged in");
		}
		String urole=(String) session.getAttribute("role");
		if(!urole.equalsIgnoreCase("Admin")) {
			throw new UserNotFoundException("You are not eligible to generate the bills");
		}
		LocalDate currentDate=LocalDate.now();
		//Month currentMonth=currentDate.getMonth();
		Double amt=bservice.calc(consumed_units);
		LocalDate dueDate=currentDate.plusDays(15);
		int currentMonth=currentDate.getMonthValue();
		Customer cust=cservice.findbyId(cust_id);
		Bill bill=new Bill(cust_id,consumer_no,consumed_units,currentMonth,currentDate,amt,dueDate,cust.getMeter_id());
		Bill bill1=bservice.add(bill);
		BillDetails details=billUtil.toDetails(bill1);
		return bill1.getBill_id();
	}


	@ResponseStatus(HttpStatus.ACCEPTED)

	@PostMapping("/payment/{cust_id},{answer},{bill_id}")

	public String paymentConfirm(@PathVariable("cust_id")Integer cust_id,@PathVariable("answer")String ans,@PathVariable("bill_id")Integer bill_id,HttpServletRequest request) {

	HttpSession session=request.getSession();

	Object c=session.getAttribute("user");

	System.out.println("obj"+c);

	if(c==null) {

	throw new UserNotFoundException("You are not logged in");

	}

	String m =bservice.paymentConfirm(cust_id,ans,bill_id);

	return m;

	}
}

