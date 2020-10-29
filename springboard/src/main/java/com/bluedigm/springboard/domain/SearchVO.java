package com.bluedigm.springboard.domain;

import java.util.List;

public class SearchVO<T> {
	List<T> list;
	T condition;
	int page;
	int pageMax;
	int size;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
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
