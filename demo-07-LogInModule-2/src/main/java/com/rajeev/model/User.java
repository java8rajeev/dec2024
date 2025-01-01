package com.rajeev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_03")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String userName;
	private String userPassword;
	public Long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
