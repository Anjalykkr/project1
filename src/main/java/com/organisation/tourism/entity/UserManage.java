package com.organisation.tourism.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserManage {
	
	@Column(name = "user_name")
	private String userName;
	
	@Id
	@Column(name = "password")
	private String password;
	
	public UserManage() {
	}
	
	public UserManage(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserManage [userName=" + userName + ", password=" + password + "]";
	}
	

}
