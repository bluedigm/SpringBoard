package com.bluedigm.springboard.domain;

import java.util.List;

import com.bluedigm.springboard.entity.JoinDAO;

public class UserHomeVO {
	List<JoinDAO> joinList;
	int page;
	int pageMax;
	int size;
	String nick;

	public List<JoinDAO> getJoinList() {
		return joinList;
	}

	public void setJoinList(List<JoinDAO> joinList) {
		this.joinList = joinList;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}
