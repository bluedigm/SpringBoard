package com.bluedigm.springboard.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.entity.BoardDAO;
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
			mav.setViewName("redirect:/board/" + vo.getLink());
		} else {
			mav.addObject("res", vo);
			mav.setViewName("board/create");
		}
		return mav;
	}

	@RequestMapping(value = "/board/{link}/join", method = RequestMethod.GET)
	public ModelAndView getJoin(HttpServletRequest http, @PathVariable("link") String link) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", boardService.join(common.getUser(http), common.getBoard(http), false));
		mav.setViewName("redirect:/board/" + link);
		return mav;
	}

	@RequestMapping(value = "/board/{link}/leave", method = RequestMethod.GET)
	public ModelAndView getLeave(HttpServletRequest http, @PathVariable("link") String link) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", boardService.leave(common.getUser(http), common.getBoard(http)));
		mav.setViewName("redirect:/board/" + link);
		return mav;
	}

	@RequestMapping(value = "/board/{link}", method = RequestMethod.GET)
	public ModelAndView getHome(HttpServletRequest http, @PathVariable("link") String link) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		Optional<BoardDAO> board = boardService.select(link);
		if (board.isPresent()) {
			common.setBoard(http, board.get());
			mav.addObject("res", boardService.home(common.getUser(http), board.get()));
		}
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
	public ModelAndView postSearch(SearchVO<BoardDAO> vo) {
		logger.info("Board Controller - Post Board Search");
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", boardService.search(vo));
		mav.setViewName("/board/search");
		return mav;
	}

}
