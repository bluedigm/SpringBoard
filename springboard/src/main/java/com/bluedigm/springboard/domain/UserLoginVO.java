package com.bluedigm.springboard.domain;

import com.bluedigm.springboard.entity.UserDAO;

public class UserLoginVO {
	UserDAO user;
	String result;
	String name;
	String pw;

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
