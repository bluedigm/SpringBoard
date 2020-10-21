package com.bluedigm.springboard.domain;

public class UserUpdateVO {
	String username;
	String nickname;
	String passwordOld;
	String passwordNew1;
	String passwordNew2;
	String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}

	public String getPasswordNew1() {
		return passwordNew1;
	}

	public void setPasswordNew1(String passwordNew1) {
		this.passwordNew1 = passwordNew1;
	}

	public String getPasswordNew2() {
		return passwordNew2;
	}

	public void setPasswordNew2(String passwordNew2) {
		this.passwordNew2 = passwordNew2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
