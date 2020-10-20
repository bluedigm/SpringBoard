package com.bluedigm.springboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.springboard.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public ModelAndView getUserCreate() {
		logger.info("Get User Create");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public ModelAndView postUserCreate() {
		logger.info("Post User Create");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.GET)
	public ModelAndView getUserDelete() {
		logger.info("Get User Delete");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	public ModelAndView postUserDelete() {
		logger.info("Post User Delete");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView getUserLogin() {
		logger.info("Get User Login");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView postUserLogin() {
		logger.info("Post User Login");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/portal", method = RequestMethod.GET)
	public ModelAndView getUserPortal() {
		logger.info("Get User Portal");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView getUserProfile() {
		logger.info("Get User Profile");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
	public ModelAndView getUserSearch() {
		logger.info("Get User Search");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
	public ModelAndView postUserSearch() {
		logger.info("Post User Search");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public ModelAndView getUserUpdate() {
		logger.info("Get User Update");
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public ModelAndView postUserUpdate() {
		logger.info("Post User Update");
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
