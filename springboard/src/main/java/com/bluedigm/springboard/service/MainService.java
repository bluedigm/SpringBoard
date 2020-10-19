package com.bluedigm.springboard.service;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.springboard.domain.TestVO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.repository.UserRepo;

/**
 * Handles requests for the application home page.
 */
@Service
public class MainService {
	@Autowired
	UserRepo userRepo;
	private static final Logger logger = LoggerFactory.getLogger(MainService.class);

	public TestVO serviceA(String name, String nick, String pw) throws Exception {
		logger.info("from: " + name + " | " + nick + " | " + pw);
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		md.update(pw.getBytes("utf8"));
		TestVO vo = new TestVO();
		vo.setEmail(name + "@springboard.org");
		vo.setNick(nick);
		vo.setPw(md.digest().toString());
		logger.info("to: " + vo.getEmail() + " | " + vo.getNick() + " | " + vo.getPw());
		UserDAO user = new UserDAO();
		user.setEmail(vo.getEmail());
		user.setNick(vo.getNick());
		user.setPassword(vo.getPw());
		userRepo.insert(user);
		return vo;
	}
}
