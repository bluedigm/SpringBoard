package com.bluedigm.springboard.domain;

public class UserUpdateVO {
	int id;
	String name;
	String nick;
	String email;
	String pwOld;
	String pwNew1;
	String pwNew2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPwOld() {
		return pwOld;
	}

	public void setPwOld(String pwOld) {
		this.pwOld = pwOld;
	}

	public String getPwNew1() {
		return pwNew1;
	}

	public void setPwNew1(String pwNew1) {
		this.pwNew1 = pwNew1;
	}

	public String getPwNew2() {
		return pwNew2;
	}

	public void setPwNew2(String pwNew2) {
		this.pwNew2 = pwNew2;
	}
}
