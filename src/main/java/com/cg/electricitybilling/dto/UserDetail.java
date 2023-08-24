package com.cg.electricitybilling.dto;

public class UserDetail {
	
	private Integer user_Id;
	private String password;
	private String role;
	
	public UserDetail()
	{
		
	}
	
	
	public UserDetail(Integer user_Id, String password, String role) {
		super();
		this.user_Id = user_Id;
		this.password = password;
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDetail [user_Id=" + user_Id + ", password=" + password + ", role=" + role + "]";
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
