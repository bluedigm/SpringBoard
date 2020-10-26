package com.bluedigm.springboard.domain;

import java.util.List;

import com.bluedigm.springboard.entity.UserDAO;

public class UserSearchVO {
	List<UserDAO> userList;
	int page;
	int pageMax;
	int size;

	public List<UserDAO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDAO> userList) {
		this.userList = userList;
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
