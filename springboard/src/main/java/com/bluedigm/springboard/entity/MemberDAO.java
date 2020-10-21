package com.bluedigm.springboard.entity;

import java.util.Date;

public class MemberDAO {
	String user;
	String board;
	boolean flag;
	Date memberAt;
	Date managerAt;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Date getMemberAt() {
		return memberAt;
	}

	public void setMemberAt(Date memberAt) {
		this.memberAt = memberAt;
	}

	public Date getManagerAt() {
		return managerAt;
	}

	public void setManagerAt(Date managerAt) {
		this.managerAt = managerAt;
	}
}
