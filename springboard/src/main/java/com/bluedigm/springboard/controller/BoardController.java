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

import com.bluedigm.springboard.Useful;
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
	public ModelAndView getCreate() {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/create");
		return mav;
	}

	@RequestMapping(value = "/board/create", method = RequestMethod.POST)
	public ModelAndView postCreate(HttpServletRequest http, BoardCreateVO vo) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		if (boardService.create(vo)) {
			mav.setViewName("redirect:/board/" + vo.getLink() + "/owner");
		} else {
			mav.addObject("res", vo);
			mav.setViewName("board/create");
		}
		return mav;
	}

	@RequestMapping(value = "/board/{link}/owner", method = RequestMethod.GET)
	public ModelAndView getOwner(HttpServletRequest http, @PathVariable("link") String link) {
		logger.info("Get Join");
		ModelAndView mav = new ModelAndView();
		if (boardService.verify(link)) {
			common.setBoard(http, link);
			mav.addObject("res", boardService.join(common.getUser(http), link, true));
			mav.setViewName("redirect:/board/" + link);
		}
		mav.setViewName("redirect:/board/" + link);
		return mav;
	}

	@RequestMapping(value = "/board/{link}/join", method = RequestMethod.GET)
	public ModelAndView getJoin(HttpServletRequest http, @PathVariable("link") String link) {
		logger.info("Get Join");
		ModelAndView mav = new ModelAndView();
		common.setBoard(http, link);
		mav.addObject("res", boardService.join(common.getUser(http), link, false));
		mav.setViewName("redirect:/board/" + link);
		return mav;
	}

	@RequestMapping(value = "/board/{link}/leave", method = RequestMethod.GET)
	public ModelAndView getLeave(HttpServletRequest http, @PathVariable("link") String link) {
		logger.info("Get Leave");
		ModelAndView mav = new ModelAndView();
		common.setBoard(http, link);
		mav.addObject("res", boardService.leave(common.getUser(http), link));
		mav.setViewName("redirect:/board/" + link);
		return mav;
	}

	@RequestMapping(value = "/board/{link}", method = RequestMethod.GET)
	public ModelAndView getHome(HttpServletRequest http, @PathVariable("link") String link) {
		logger.info("Board Controller - Get Board Home");
		ModelAndView mav = new ModelAndView();
		common.setBoard(http, link);
		mav.addObject("res", boardService.home(common.getUser(http), link));
		mav.setViewName("/board/home");
		return mav;
	}

	@RequestMapping(value = "/board/search", method = RequestMethod.GET)
	public ModelAndView getSearch() {
		logger.info("Board Controller - Get Board Search");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", boardService.search());
		mav.setViewName("/board/search");
		return mav;
	}

	@RequestMapping(value = "/board/search", method = RequestMethod.POST)
	public ModelAndView postSearch(BoardSearchVO vo) {
		logger.info("Board Controller - Post Board Search");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", boardService.search(vo));
		mav.setViewName("/board/search");
		return mav;
	}

}
