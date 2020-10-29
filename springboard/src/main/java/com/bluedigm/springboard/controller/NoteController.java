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
import com.bluedigm.springboard.domain.NoteCreateVO;
import com.bluedigm.springboard.entity.BoardDAO;
import com.bluedigm.springboard.entity.NoteDAO;
import com.bluedigm.springboard.service.BoardService;
import com.bluedigm.springboard.service.UserService;
import com.bluedigm.springboard.service.impl.NoteServiceImpl;

//
@Controller
public class NoteController {
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
	@Autowired
	BoardService boardService;
	@Autowired
	NoteServiceImpl noteService;
	@Autowired
	UserService userService;
	@Autowired
	Common common;

	@RequestMapping(value = "/note/create", method = RequestMethod.GET)
	public ModelAndView getCreate() {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("note/create");
		return mav;
	}

	@RequestMapping(value = "/board/{link}/note/create", method = RequestMethod.POST)
	public ModelAndView postCreate(HttpServletRequest http, NoteCreateVO vo, @PathVariable("link") String link) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		vo.setUserId(common.getUser(http).getId());
		vo.setBoardId(common.getBoard(http).getId());
		if (noteService.create(vo)) {
			mav.setViewName("redirect:/board/" + common.getBoard(http));
		} else {
			mav.addObject("res", vo);
			mav.setViewName("note/create");
		}
		return mav;
	}

	@RequestMapping(value = "/note/{id}", method = RequestMethod.GET)
	public ModelAndView getHome(HttpServletRequest http, @PathVariable("id") Integer id) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		Optional<NoteDAO> note = noteService.select(id);
		if (note.isPresent()) {
			mav.addObject("res", note.get());
		}
		mav.setViewName("/note/home");
		return mav;
	}
}
