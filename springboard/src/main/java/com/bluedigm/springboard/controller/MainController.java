package com.bluedigm.springboard.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.springboard.Useful;
import com.bluedigm.springboard.domain.UserCreateVO;
import com.bluedigm.springboard.domain.UserDeleteVO;
import com.bluedigm.springboard.domain.UserLoginVO;
import com.bluedigm.springboard.domain.UserResetVO;
import com.bluedigm.springboard.domain.SearchVO;
import com.bluedigm.springboard.domain.UserUpdateVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	Common common;
	@Autowired
	BoardController boardController;
	@Autowired
	NoteController noteController;
//	@Autowired
//	UserController userController;

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest http, Locale locale, Model model) {
		logger.info(Useful.getMethodName());
		ModelAndView mav = new ModelAndView();
		if (common.checkLogin(http)) {
			mav.setViewName("redirect:/user/home");
			return mav;
		}
		mav.setViewName("/home");
		return mav;
	}
}
