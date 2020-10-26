package com.bluedigm.springboard.domain;

import java.util.Date;
import java.util.List;

import com.bluedigm.springboard.entity.JoinDAO;

public class BoardHomeVO {
	List<JoinDAO> list;
	boolean member;
	String link;
	String title;
	String text;
	Date createAt;
	Date updateAt;

	public List<JoinDAO> getList() {
		return list;
	}

	public void setList(List<JoinDAO> list) {
		this.list = list;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
