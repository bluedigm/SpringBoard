package com.bluedigm.springboard.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluedigm.springboard.service.MainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	MainService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "linkA")
	public void linkA() {
		logger.info("linkA called");
	}

	@RequestMapping(value = "linkB")
	public void linkB() {
		logger.info("linkB called");
	}

	@RequestMapping(value = "linkC")
	public String linkC(@ModelAttribute("msg") String text) {
		logger.info("linkC {} called".formatted(text));
		return "result";
	}

	@RequestMapping(value = "user")
	public String linkC(Model model, @ModelAttribute("user") String user, @ModelAttribute("nick") String nick,
			@ModelAttribute("pw") String pw) {
		logger.info("user in controller");

		try {
			model.addAttribute("model", service.serviceA(user, nick, pw));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user";
	}
}
