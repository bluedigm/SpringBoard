package com.bluedigm.springboard.domain;

import java.util.Date;

public class UserUpdateVO {
	String result;
	Integer id;
	String name;
	String nick;
	String email;
	String pw;
	String pwOld;
	String pwNew;
	Date createAt;
	Date updateAt;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getPwNew() {
		return pwNew;
	}

	public void setPwNew(String pwNew) {
		this.pwNew = pwNew;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
}
