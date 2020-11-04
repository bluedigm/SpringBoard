package com.bluedigm.springboard.domain;

import java.util.List;

import com.bluedigm.springboard.entity.UserDAO;

public class UserSearchVO {
	List<UserDAO> list;
	UserDAO condition;
	int page;
	int pageMax;
	int size;

	public List<UserDAO> getList() {
		return list;
	}

	public void setList(List<UserDAO> list) {
		this.list = list;
	}

	public UserDAO getCondition() {
		return condition;
	}

	public void setCondition(UserDAO condition) {
		this.condition = condition;
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
