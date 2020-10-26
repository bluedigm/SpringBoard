package com.bluedigm.springboard.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.MemberDAO;
import com.bluedigm.springboard.entity.NoteDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.entity.join.MemberJoin;
import com.bluedigm.springboard.entity.join.NoteJoin;

public class BoardHomeVO {
	List<NoteJoin> noteList;
	String title;
	String text;
	Date createAt;
	Date updateAt;

	public List<NoteJoin> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<NoteJoin> noteList) {
		this.noteList = noteList;
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
