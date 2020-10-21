package com.bluedigm.springboard.domain;

import java.util.Date;
import java.util.List;

import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.ContentDAO;

public class UserProfileVO {
	String username;
	String nickname;
	String email;
	Date createAt;
	Date updateAt;
	int boardPage;
	int boardSize;
	int contentPage;
	int contentSize;
//	List<BoardDAO> boardList;
//	List<ContentDAO> contentList;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
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
