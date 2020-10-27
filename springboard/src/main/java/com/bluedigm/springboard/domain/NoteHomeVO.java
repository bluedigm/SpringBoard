package com.bluedigm.springboard.domain;

import java.util.Date;
import java.util.List;

import com.bluedigm.springboard.entity.JoinDAO;

public class NoteHomeVO {
	String title;
	String text;
	Date createAt;
	Date updateAt;

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
