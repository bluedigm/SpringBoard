package com.bluedigm.springboard.domain;

import com.bluedigm.springboard.entity.UserDAO;

public class UserLoginVO {
	UserDAO user;

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}
}
