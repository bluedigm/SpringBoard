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
import com.bluedigm.springboard.domain.NoteCreateVO;
import com.bluedigm.springboard.service.BoardService;
import com.bluedigm.springboard.service.NoteService;

//
@Controller
public class NoteController {
	private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
	@Autowired
	BoardService boardService;
	@Autowired
	NoteService noteService;
	@Autowired
	Common common;

	@RequestMapping(value = "/note/create", method = RequestMethod.GET)
	public ModelAndView getNoteCreate() {
		logger.info("Note Controller - Get Note Create");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("note/create");
		return mav;
	}

	@RequestMapping(value = "/note/create", method = RequestMethod.POST)
	public ModelAndView postNoteCreate(HttpServletRequest http, NoteCreateVO vo) {
		logger.info("Note Controller - Post Note Create");
		ModelAndView mav = new ModelAndView();
		vo.setUserId(common.getUser(http));
		vo.setBoardId(common.getBoard(http));
		if (noteService.create(vo)) {
			mav.setViewName("redirect:/board/" + boardService.check(common.getBoard(http)));
		} else {
			mav.addObject("res", vo);
			mav.setViewName("note/create");
		}
		return mav;
	}
}