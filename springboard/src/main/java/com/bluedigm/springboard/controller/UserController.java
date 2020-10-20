package com.bluedigm.springboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserSearchVO;
import com.bluedigm.springboard.domain.UserUpdateVO;
import com.bluedigm.springboard.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@RequestMapping(value = "user/create", method = RequestMethod.GET)
	public ModelAndView getUserCreate() {
		logger.info("User Controller - Get User Create");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/create");
		return mav;
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public ModelAndView postUserCreate(UserCreateVO user) {
		logger.info("User Controller - Post User Create");
		ModelAndView mav = new ModelAndView();
		userService.create(user);
		return mav;
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.GET)
	public ModelAndView getUserDelete() {
		logger.info("User Controller - Get User Delete");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/delete");
		return mav;
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	public ModelAndView postUserDelete(UserDeleteVO user) {
		logger.info("User Controller - Post User Delete");
		ModelAndView mav = new ModelAndView();
		userService.delete(user);
		return mav;
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView getUserLogin() {
		logger.info("User Controller - Get User Login");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/login");
		return mav;
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView postUserLogin(UserLoginVO user) {
		logger.info("User Controller - Post User Login");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/portal", method = RequestMethod.GET)
	public ModelAndView getUserPortal() {
		logger.info("User Controller - Get User Portal");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/portal");
		return mav;
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView getUserProfile() {
		logger.info("User Controller - Get User Profile");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/profile");
		return mav;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
	public ModelAndView getUserSearch() {
		logger.info("User Controller - Get User Search");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/search");
		return mav;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
	public ModelAndView postUserSearch(UserSearchVO user) {
		logger.info("User Controller - Post User Search");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public ModelAndView getUserUpdate() {
		logger.info("User Controller - Get User Update");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/update");
		return mav;
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public ModelAndView postUserUpdate(UserUpdateVO user) {
		logger.info("User Controller - Post User Update");
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
