package com.bluedigm.springboard.domain;

import java.util.List;

import com.bluedigm.springboard.entity.BoardDAO;

/**
 * @author Yerunokasiar
 *
 */
public class BoardSearchVO {
	List<BoardDAO> list;
	int page;
	int pageMax;
	int size;

	public List<BoardDAO> getList() {
		return list;
	}

	public void setList(List<BoardDAO> list) {
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