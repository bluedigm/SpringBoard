//package com.bluedigm.springboard.controller;
//
//import java.util.Date;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.bluedigm.springboard.domain.UserCreateVO;
//import com.bluedigm.springboard.domain.UserDeleteVO;
//import com.bluedigm.springboard.domain.UserLoginVO;
//import com.bluedigm.springboard.domain.UserSearchVO;
//import com.bluedigm.springboard.domain.UserUpdateVO;
//import com.bluedigm.springboard.service.UserService;
//
//@Controller
//public class BoardController {
//	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
//	@Autowired
//	UserService userService;
//
//	boolean checkSession(HttpServletRequest http) {
//		return getSession(http) != null;
//	}
//
//	HttpSession getSession(HttpServletRequest http) {
//		return http.getSession(false);
//	}
//
//	void setLogin(HttpServletRequest http, int id, Date at) {
//		if (checkSession(http)) {
//			getSession(http).setAttribute("springboard_id", id);
//			getSession(http).setAttribute("springboard_date", at);
//		}
//	}
//
//	Integer getLoginId(HttpServletRequest http) {
//		if (checkSession(http)) {
//			return (int) getSession(http).getAttribute("springboard_id");
//		}
//		return null;
//	}
//
//	Date getLoginDate(HttpServletRequest http) {
//		if (checkSession(http)) {
//			return (Date) getSession(http).getAttribute("springboard_date");
//		}
//		return null;
//	}
//
//	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
//	public ModelAndView getUserCreate() {
//		logger.info("User Controller - Get User Create");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("user/create");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
//	public ModelAndView postUserCreate(UserCreateVO vo) {
//		logger.info("User Controller - Post User Create");
//		ModelAndView mav = new ModelAndView();
//		if (userService.create(vo)) {
//			mav.setViewName("redirect:/user/login");
//		} else {
//			mav.addObject("res", vo);
//			mav.setViewName("user/create");
//		}
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/delete", method = RequestMethod.GET)
//	public ModelAndView getUserDelete(HttpServletRequest http) {
//		logger.info("User Controller - Get User Delete");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("res", userService.delete(getLoginId(http)));
//		mav.setViewName("user/delete");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/delete", method = RequestMethod.POST)
//	public ModelAndView postUserDelete(HttpServletRequest http, UserDeleteVO vo) {
//		logger.info("User Controller - Post User Delete");
//		ModelAndView mav = new ModelAndView();
//		vo.setId(getLoginId(http));
//		if (userService.delete(vo)) {
//			mav.setViewName("redirect:/user/login");
//		} else {
//			mav.addObject("res", vo);
//			mav.setViewName("user/delete");
//		}
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
//	public ModelAndView getUserLogin() {
//		logger.info("User Controller - Get User Login");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/user/login");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
//	public ModelAndView postUserLogin(HttpServletRequest http, UserLoginVO vo) {
//		logger.info("User Controller - Post User Login");
//		ModelAndView mav = new ModelAndView();
//		if (userService.login(vo)) {
//			http.getSession(true);
//			setLogin(http, vo.getId(), vo.getDate());
//			mav.setViewName("redirect:/user/portal");
//		} else {
//			mav.addObject("res", vo);
//			mav.setViewName("/user/login");
//		}
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
//	public ModelAndView getUserLogout(HttpServletRequest http) {
//		logger.info("User Controller - Get User Logout");
//		ModelAndView mav = new ModelAndView();
//		http.getSession(true);
//		mav.setViewName("redirect:/user/login");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/portal", method = RequestMethod.GET)
//	public ModelAndView getUserPortal() {
//		logger.info("User Controller - Get User Portal");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/user/portal");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
//	public ModelAndView getUserProfile(HttpServletRequest http) {
//		logger.info("User Controller - Get User Profile");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("res", userService.profile(getLoginId(http)));
//		mav.setViewName("/user/profile");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
//	public ModelAndView getUserSearch() {
//		logger.info("User Controller - Get User Search");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("res", userService.search());
//		mav.setViewName("/user/search");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
//	public ModelAndView postUserSearch(UserSearchVO vo) {
//		logger.info("User Controller - Post User Search");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("res", userService.search(vo));
//		mav.setViewName("/user/search");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
//	public ModelAndView getUserUpdate(HttpServletRequest http) {
//		logger.info("User Controller - Get User Update");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("res", userService.update(getLoginId(http)));
//		mav.setViewName("/user/update");
//		return mav;
//	}
//
//	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
//	public ModelAndView postUserUpdate(HttpServletRequest http, UserUpdateVO vo) {
//		logger.info("User Controller - Post User Update");
//		ModelAndView mav = new ModelAndView();
//		vo.setId(getLoginId(http));
//		if (userService.update(vo)) {
//			mav.setViewName("redirect:/user/profile");
//		} else {
//			mav.addObject("res", vo);
//			mav.setViewName("/user/update");
//		}
//		return mav;
//	}
//}
