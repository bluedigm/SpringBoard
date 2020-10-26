package com.bluedigm.springboard.entity.join;

import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.NoteDAO;
import com.bluedigm.springboard.entity.UserDAO;

public class NoteJoin {
	UserDAO user;
	BoardDAO board;
	NoteDAO note;

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

	public NoteDAO getNote() {
		return note;
	}

	public void setNote(NoteDAO note) {
		this.note = note;
	}
}
