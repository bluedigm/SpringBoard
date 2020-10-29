package com.bluedigm.springboard.entity;

import java.util.Date;

public class MemberDAO {
	Integer boardId;
	Integer userId;
	Boolean opFlag;
	Date managerAt;
	Date memberAt;

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getOpFlag() {
		return opFlag;
	}

	public void setOpFlag(Boolean opFlag) {
		this.opFlag = opFlag;
	}

	public Date getManagerAt() {
		return managerAt;
	}

	public void setManagerAt(Date managerAt) {
		this.managerAt = managerAt;
	}

	public Date getMemberAt() {
		return memberAt;
	}

	public void setMemberAt(Date memberAt) {
		this.memberAt = memberAt;
	}
}
