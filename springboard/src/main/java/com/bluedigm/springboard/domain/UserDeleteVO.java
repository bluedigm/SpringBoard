package com.bluedigm.springboard.domain;

public class UserDeleteVO {
	String result;
	String name;
	String pw;
	String pwOld;

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

	public String getPwOld() {
		return pwOld;
	}

	public void setPwOld(String pwOld) {
		this.pwOld = pwOld;
	}
}
