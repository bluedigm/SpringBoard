package com.bluedigm.springboard.entity;

import java.util.Date;

public class MemberDAO {
	int userId;
	int boardId;
	boolean flagOp;
	Date memberAt;
	Date managerAt;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public boolean isFlagOp() {
		return flagOp;
	}

	public void setFlagOp(boolean flagOp) {
		this.flagOp = flagOp;
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
