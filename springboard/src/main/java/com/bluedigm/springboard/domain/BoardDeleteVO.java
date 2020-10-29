package com.bluedigm.springboard.domain;

import com.bluedigm.springboard.entity.UserDAO;

public class BoardDeleteVO {
	UserDAO user;
	String pw;

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
