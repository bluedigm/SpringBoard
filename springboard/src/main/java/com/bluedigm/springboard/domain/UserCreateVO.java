package com.bluedigm.springboard.domain;

public class UserCreateVO {
	String result;
	String name;
	String nick;
	String email;
	String pw;
	String pwNew;

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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPwNew() {
		return pwNew;
	}

	public void setPwNew(String pwNew) {
		this.pwNew = pwNew;
	}
}
