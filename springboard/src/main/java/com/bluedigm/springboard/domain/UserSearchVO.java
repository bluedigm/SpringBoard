package com.bluedigm.springboard.domain;

import java.util.List;

import com.bluedigm.springboard.entity.UserDAO;

public class UserSearchVO {
	List<UserDAO> userList;
	int userPage;
	int userMaxPage;
	int userSize;

	public List<UserDAO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDAO> userList) {
		this.userList = userList;
	}

	public int getUserPage() {
		return userPage;
	}

	public void setUserPage(int userPage) {
		this.userPage = userPage;
	}

	public int getUserMaxPage() {
		return userMaxPage;
	}

	public void setUserMaxPage(int userMaxPage) {
		this.userMaxPage = userMaxPage;
	}

	public int getUserSize() {
		return userSize;
	}

	public void setUserSize(int userSize) {
		this.userSize = userSize;
	}

}
