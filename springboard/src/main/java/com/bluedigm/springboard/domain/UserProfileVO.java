package com.bluedigm.springboard.domain;

import java.util.Date;

public class UserProfileVO {
	String name;
	String nick;
	String email;
	Date createAt;
	Date updateAt;
	int boardPage;
	int boardSize;
	int contentPage;
	int contentSize;
//	List<BoardDAO> boardList;
//	List<ContentDAO> contentList;

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getBoardPage() {
		return boardPage;
	}

	public void setBoardPage(int boardPage) {
		this.boardPage = boardPage;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public int getContentPage() {
		return contentPage;
	}

	public void setContentPage(int contentPage) {
		this.contentPage = contentPage;
	}

	public int getContentSize() {
		return contentSize;
	}

	public void setContentSize(int contentSize) {
		this.contentSize = contentSize;
	}

//	public List<BoardDAO> getBoardList() {
//		return boardList;
//	}
//
//	public void setBoardList(List<BoardDAO> boardList) {
//		this.boardList = boardList;
//	}
//
//	public List<ContentDAO> getContentList() {
//		return contentList;
//	}
//
//	public void setContentList(List<ContentDAO> contentList) {
//		this.contentList = contentList;
//	}
}
