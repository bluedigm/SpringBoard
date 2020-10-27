package com.bluedigm.springboard.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	void setLogin(HttpServletRequest http, String user, Date at) {
		if (checkSession(http)) {
			setUser(http, user);
			setDate(http, at);
		}
	}

	String getUser(HttpServletRequest http) {
		if (checkSession(http))
			return (String) getSession(http).getAttribute("springboard_user");
		return null;
	}

	void setUser(HttpServletRequest http, String user) {
		if (checkSession(http))
			getSession(http).setAttribute("springboard_user", user);
	}

	Date getDate(HttpServletRequest http) {
		if (checkSession(http))
			return (Date) getSession(http).getAttribute("springboard_date");
		return null;
	}

	void setDate(HttpServletRequest http, Date at) {
		if (checkSession(http))
			getSession(http).setAttribute("springboard_date", at);
	}

	String getBoard(HttpServletRequest http) {
		if (checkSession(http))
			return (String) getSession(http).getAttribute("springboard_board");
		return null;
	}

	void setBoard(HttpServletRequest http, String board) {
		if (checkSession(http))
			getSession(http).setAttribute("springboard_board", board);
	}

	boolean checkLogin(HttpServletRequest http) {
		if (checkSession(http)) {
			String user = getUser(http);
			Date time = getDate(http);
			if (user != null && time != null) {
				return userService.verify(user, time);
			}
		}
		return false;
	}
}
