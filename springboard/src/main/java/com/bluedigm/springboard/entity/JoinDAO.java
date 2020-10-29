package com.bluedigm.springboard.entity;

public class JoinDAO {
	BoardDAO board;
	MemberDAO member;
	NoteDAO note;
	UserDAO user;

	public BoardDAO getBoard() {
		return board;
	}

	public void setBoard(BoardDAO board) {
		this.board = board;
	}

	public MemberDAO getMember() {
		return member;
	}

	public void setMember(MemberDAO member) {
		this.member = member;
	}

	public NoteDAO getNote() {
		return note;
	}

	public void setNote(NoteDAO note) {
		this.note = note;
	}

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}
}
