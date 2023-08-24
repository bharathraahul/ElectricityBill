package com.cg.electricitybilling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer admin_id;
	private Integer user_id;
	private String name;
	private String email;
	private Long phone;
	
	public Admin() {
		
	}
	public Admin(Integer user_id, String name, String email, Long phone) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	
	
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", user_id=" + user_id + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	

}
