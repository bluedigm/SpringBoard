package com.bluedigm.springboard.service;

import java.util.List;

import com.bluedigm.springboard.entity.UserDAO;

public interface MailService {
	public void simpleMail(UserDAO dao);

	public void mimeMail(UserDAO dao, List<String> pathList);
}
