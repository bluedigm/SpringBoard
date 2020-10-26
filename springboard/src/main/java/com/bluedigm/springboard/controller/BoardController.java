package com.bluedigm.springboard.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.springboard.domain.BoardCreateVO;
import com.bluedigm.springboard.domain.BoardSearchVO;
import com.bluedigm.springboard.service.BoardService;

//
@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	BoardService boardService;
	@Autowired
	Common common;

	@RequestMapping(value = "/board/create", method = RequestMethod.GET)
	public ModelAndView getBoardCreate() {
		logger.info("Board Controller - Get Board Create");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/create");
		return mav;
	}

	@RequestMapping(value = "/board/create", method = RequestMethod.POST)
	public ModelAndView postBoardCreate(HttpServletRequest http, BoardCreateVO vo) {
		logger.info("Board Controller - Post Board Create");
		ModelAndView mav = new ModelAndView();
		vo.setUserId(common.getUser(http));
		if (boardService.create(vo)) {
			mav.setViewName("redirect:/board/home");
		} else {
			mav.addObject("res", vo);
			mav.setViewName("board/create");
		}
		return mav;
	}

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

//	@RequestMapping(value = "/board/home", method = RequestMethod.GET)
//	public ModelAndView getBoardHome(HttpServletRequest http) {
//		logger.info("Board Controller - Get Board Home");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("res", boardService.home(common.getLoginId(http)));
//		mav.setViewName("/board/home");
//		return mav;
//	}

	@RequestMapping(value = "/board/{link}", method = RequestMethod.GET)
	public ModelAndView getBoardHome(HttpServletRequest http, @PathVariable("link") String link) {
		logger.info("Board Controller - Get Board Home");
		ModelAndView mav = new ModelAndView();
		common.setBoard(http, boardService.check(link));
		mav.addObject("res", boardService.home(link));
		mav.setViewName("/board/home");
		return mav;
	}
//	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
//	public ModelAndView getUserProfile(HttpServletRequest http) {
//		logger.info("User Controller - Get User Profile");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("res", userService.profile(getLoginId(http)));
//		mav.setViewName("/user/profile");
//		return mav;
//	}

	@RequestMapping(value = "/board/search", method = RequestMethod.GET)
	public ModelAndView getBoardSearch() {
		logger.info("Board Controller - Get Board Search");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", boardService.search());
		mav.setViewName("/board/search");
		return mav;
	}

	@RequestMapping(value = "/board/search", method = RequestMethod.POST)
	public ModelAndView postBoardSearch(BoardSearchVO vo) {
		logger.info("Board Controller - Post Board Search");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", boardService.search(vo));
		mav.setViewName("/board/search");
		return mav;
	}
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
}
