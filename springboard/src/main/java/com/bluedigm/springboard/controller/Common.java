package com.bluedigm.springboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.UserDAO;
import com.bluedigm.springboard.service.UserService;

@Component
public class Common {
	@Autowired
	UserService userService;

	boolean checkSession(HttpServletRequest http) {
		return getSession(http) != null;
	}

	HttpSession getSession(HttpServletRequest http) {
		return http.getSession(false);
	}

	UserDAO getUser(HttpServletRequest http) {
		if (checkSession(http))
			return (UserDAO) getSession(http).getAttribute("springboard_user");
		return null;
	}

	void setUser(HttpServletRequest http, UserDAO user) {
		if (checkSession(http))
			getSession(http).setAttribute("springboard_user", user);
	}

	BoardDAO getBoard(HttpServletRequest http) {
		if (checkSession(http))
			getSession(http).getAttribute("springboard_board");
		return null;
	}

	void setBoard(HttpServletRequest http, BoardDAO board) {
		if (checkSession(http))
			getSession(http).setAttribute("springboard_board", board);
	}

	boolean checkLogin(HttpServletRequest http) {
		if (checkSession(http)) {
			UserDAO user = getUser(http);
			if (user != null) {
				return userService.verify(user);
			}
		}
		return false;
	}
}
