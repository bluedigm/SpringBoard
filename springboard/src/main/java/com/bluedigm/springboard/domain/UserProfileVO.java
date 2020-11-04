package com.bluedigm.springboard.domain;

import java.util.Date;

import com.bluedigm.springboard.entity.UserDAO;

public class UserProfileVO {
	Integer id;
	String name;
	String nick;
	String email;
	String pw;
	Date createAt;
	Date updateAt;
	int boardPage;
	int boardSize;
	int contentPage;
	int contentSize;
//	List<BoardDAO> boardList;
//	List<ContentDAO> contentList;

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
