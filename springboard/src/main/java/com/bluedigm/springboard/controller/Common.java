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

	void setLogin(HttpServletRequest http, int id, Date at) {
		if (checkSession(http)) {
			setUser(http, id);
			setDate(http, at);
		}
	}

	Integer getUser(HttpServletRequest http) {
		if (checkSession(http))
			return (Integer) getSession(http).getAttribute("springboard_user");
		return null;
	}

	void setUser(HttpServletRequest http, Integer id) {
		if (checkSession(http))
			getSession(http).setAttribute("springboard_user", id);
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

	Integer getBoard(HttpServletRequest http) {
		if (checkSession(http))
			return (Integer) getSession(http).getAttribute("springboard_board");
		return null;
	}

	void setBoard(HttpServletRequest http, Integer id) {
		if (checkSession(http))
			getSession(http).setAttribute("springboard_board", id);
	}

	boolean checkLogin(HttpServletRequest http) {
		if (checkSession(http)) {
			Integer id = getUser(http);
			Date time = getDate(http);
			if (id != null && time != null) {
				return userService.verify(id, time);
			}
		}
		return false;
	}
}
