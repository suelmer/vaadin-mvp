package com.jrtech.tools.admins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = {"/old"}, method = RequestMethod.GET)
	public String getHomeView() {
		return "redirect:/views";
	}
}
