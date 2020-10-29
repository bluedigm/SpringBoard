package com.bluedigm.springboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.springboard.Useful;
import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserResetVO;
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
	public ModelAndView getCreate() {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/create");
		return mav;
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public ModelAndView postCreate(UserCreateVO vo) {
		logger.info(Useful.getMethodName());
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
	public ModelAndView getDelete(HttpServletRequest http) {
		logger.info(Useful.getMethodName());
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
	public ModelAndView postDelete(HttpServletRequest http, UserDeleteVO vo) {
		logger.info(Useful.getMethodName());
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
	public ModelAndView getEdit(HttpServletRequest http) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", userService.edit(common.getUser(http)));
		mav.setViewName("/user/edit");
		return mav;
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	public ModelAndView postEdit(HttpServletRequest http, UserUpdateVO vo) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		if (userService.edit(common.getUser(http), vo)) {
			mav.setViewName("redirect:/user/profile");
			return mav;
		}
		mav.addObject("res", vo);
		mav.setViewName("/user/edit");
		return mav;
	}

	@RequestMapping(value = "/user/home", method = RequestMethod.GET)
	public ModelAndView getHome(HttpServletRequest http) {
		logger.info(Useful.getMethodName());
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
	public ModelAndView getLogin() {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/login");
		return mav;
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView postLogin(HttpServletRequest http, UserLoginVO vo) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		if (userService.login(vo)) {
			http.getSession(true);
			common.setLogin(http, vo.getName(), vo.getDate());
			mav.setViewName("redirect:/user/home");
			return mav;
		}
		mav.addObject("res", vo);
		mav.setViewName("/user/login");
		return mav;
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public ModelAndView getLogout(HttpServletRequest http) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		http.getSession().invalidate();
		http.getSession(true);
		mav.setViewName("/user/logout");
		return mav;
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public ModelAndView getProfile(HttpServletRequest http) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", userService.profile(common.getUser(http)));
		mav.setViewName("/user/profile");
		return mav;
	}

	@RequestMapping(value = "/user/reset", method = RequestMethod.GET)
	public ModelAndView getReset() {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/reset");
		return mav;
	}

	@RequestMapping(value = "/user/reset", method = RequestMethod.POST)
	public ModelAndView postReset(UserResetVO vo) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		if (userService.reset(vo)) {
			mav.setViewName("redirect:/user/login");
			return mav;
		}
		mav.addObject("res", vo);
		mav.setViewName("/user/reset");
		return mav;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
	public ModelAndView getSearch() {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", userService.search());
		mav.setViewName("/user/search");
		return mav;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
	public ModelAndView postSearch(UserSearchVO vo) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", userService.search(vo));
		mav.setViewName("/user/search");
		return mav;
	}
}
