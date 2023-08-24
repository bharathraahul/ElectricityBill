package com.cg.electricitybilling.dto;

public class CreateCustomerRequest {
	
	private Integer user_id;
	private String name;
	private String address;
	private Long phone;
	private Integer meter_id;
	private String email;
	private String password;
	
	public CreateCustomerRequest()
	{
		
	}
	
	public CreateCustomerRequest(Integer user_id, String name, String address, Long phone, Integer meter_id,
			String email,String password) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.meter_id = meter_id;
		this.email = email;
		this.password=password;
	}

	

	@Override
	public String toString() {
		return "CreateCustomerRequest [user_id=" + user_id + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", meter_id=" + meter_id + ", email=" + email + ", password=" + password + "]";
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Integer getMeter_id() {
		return meter_id;
	}

	public void setMeter_id(Integer meter_id) {
		this.meter_id = meter_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 
	

}
