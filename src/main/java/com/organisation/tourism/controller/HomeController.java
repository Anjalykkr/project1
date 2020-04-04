package com.organisation.tourism.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String redirectPage(HttpServletRequest request) {
		request.getSession(true);
		return "page";
	}
	
}
