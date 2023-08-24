package com.cg.electricitybilling.dto;

public class UserDto {
	private Integer user_id;
	private String user_name;
	private String password;
	private String role;
	
	public UserDto()
	{
		
	}
	public UserDto(Integer user_id,String password, String role) {
		super();
		this.user_id=user_id;
		this.password=password;
		this.role=role;
		}

		
	
	public UserDto(Integer user_id, String user_name, String password, String role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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


