package com.bluedigm.springboard.controller;

import javax.servlet.http.HttpServletRequest;

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
	@Autowired
	Common common;

	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public ModelAndView getUserCreate() {
		logger.info("User Controller - Get User Create");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/create");
		return mav;
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public ModelAndView postUserCreate(UserCreateVO vo) {
		logger.info("User Controller - Post User Create");
		ModelAndView mav = new ModelAndView();
		if (userService.create(vo)) {
			mav.setViewName("redirect:/user/login");
			return mav;
		}
		mav.addObject("res", vo);
		mav.setViewName("/user/create");
		return mav;
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.GET)
	public ModelAndView getUserDelete(HttpServletRequest http) {
		logger.info("User Controller - Get User Delete");
		ModelAndView mav = new ModelAndView();
		if (!common.checkLogin(http)) {
			mav.setViewName("redirect:/home");
			return mav;
		}
		mav.addObject("res", userService.delete(common.getUser(http)));
		mav.setViewName("/user/delete");
		return mav;
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
	public ModelAndView postUserDelete(HttpServletRequest http, UserDeleteVO vo) {
		logger.info("User Controller - Post User Delete");
		ModelAndView mav = new ModelAndView();
		if (!common.checkLogin(http)) {
			mav.setViewName("redirect:/home");
			return mav;
		}
		if (userService.delete(common.getUser(http), vo)) {
			mav.setViewName("redirect:/user/login");
			return mav;
		}
		mav.addObject("res", vo);
		mav.setViewName("/user/delete");
		return mav;
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.GET)
	public ModelAndView getUserUpdate(HttpServletRequest http) {
		logger.info("User Controller - Get User Edit");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", userService.edit(common.getUser(http)));
		mav.setViewName("/user/update");
		return mav;
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	public ModelAndView postUserUpdate(HttpServletRequest http, UserUpdateVO vo) {
		logger.info("User Controller - Post User Edit");
		ModelAndView mav = new ModelAndView();
		if (userService.edit(common.getUser(http), vo)) {
			mav.setViewName("redirect:/user/profile");
			return mav;
		}
		mav.addObject("res", vo);
		mav.setViewName("/user/update");
		return mav;
	}

	@RequestMapping(value = "/user/home", method = RequestMethod.GET)
	public ModelAndView getUserHome(HttpServletRequest http) {
		logger.info("User Controller - Get User Home");
		ModelAndView mav = new ModelAndView();
		if (!common.checkLogin(http)) {
			mav.setViewName("redirect:/home");
			return mav;
		}
		mav.addObject("res", userService.home(common.getUser(http)));
		mav.setViewName("/user/home");
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
	public ModelAndView postUserLogin(HttpServletRequest http, UserLoginVO vo) {
		logger.info("User Controller - Post User Login");
		ModelAndView mav = new ModelAndView();
		if (userService.login(vo)) {
			http.getSession(true);
			common.setLogin(http, vo.getId(), vo.getDate());
			mav.setViewName("redirect:/user/home");
			return mav;
		}
		mav.addObject("res", vo);
		mav.setViewName("/user/login");
		return mav;
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public ModelAndView getUserLogout(HttpServletRequest http) {
		logger.info("User Controller - Get User Logout");
		ModelAndView mav = new ModelAndView();
		http.getSession(true);
		mav.setViewName("redirect:/user/login");
		return mav;
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView getUserProfile(HttpServletRequest http) {
		logger.info("User Controller - Get User Profile");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", userService.profile(common.getUser(http)));
		mav.setViewName("/user/profile");
		return mav;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
	public ModelAndView getUserSearch() {
		logger.info("User Controller - Get User Search");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", userService.search());
		mav.setViewName("/user/search");
		return mav;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
	public ModelAndView postUserSearch(UserSearchVO vo) {
		logger.info("User Controller - Post User Search");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", userService.search(vo));
		mav.setViewName("/user/search");
		return mav;
	}
}
