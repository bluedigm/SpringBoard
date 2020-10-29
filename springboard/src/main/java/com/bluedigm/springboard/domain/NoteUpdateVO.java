package com.bluedigm.springboard.domain;

import com.bluedigm.springboard.entity.UserDAO;

public class NoteUpdateVO {
	UserDAO user;
	String pwOld;
	String pwNew;

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public String getPwOld() {
		return pwOld;
	}

	public void setPwOld(String pwOld) {
		this.pwOld = pwOld;
	}

	public String getPwNew() {
		return pwNew;
	}

	public void setPwNew(String pwNew) {
		this.pwNew = pwNew;
	}
}
