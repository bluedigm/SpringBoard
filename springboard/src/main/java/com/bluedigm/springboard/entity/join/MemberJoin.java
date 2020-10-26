package com.bluedigm.springboard.entity.join;

import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.MemberDAO;
import com.bluedigm.springboard.entity.UserDAO;

public class MemberJoin {
	MemberDAO member;
	UserDAO user;
	BoardDAO board;

	public MemberDAO getMember() {
		return member;
	}

	public void setMember(MemberDAO member) {
		this.member = member;
	}

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public BoardDAO getBoard() {
		return board;
	}

	public void setBoard(BoardDAO board) {
		this.board = board;
	}
}
