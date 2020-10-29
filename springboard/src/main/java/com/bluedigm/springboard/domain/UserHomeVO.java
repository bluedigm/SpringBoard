package com.bluedigm.springboard.domain;

import java.util.List;

import com.bluedigm.springboard.entity.JoinDAO;
import com.bluedigm.springboard.entity.UserDAO;

public class UserHomeVO {
	UserDAO user;
	List<JoinDAO> list;
	int page;
	int pageMax;
	int size;

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public List<JoinDAO> getList() {
		return list;
	}

	public void setList(List<JoinDAO> list) {
		this.list = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageMax() {
		return pageMax;
	}

	public void setPageMax(int pageMax) {
		this.pageMax = pageMax;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
