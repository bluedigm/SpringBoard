package com.bluedigm.springboard.entity;

import java.util.Date;

public class MemberDAO {
	int userId;
	int boardId;
	boolean flag;
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
