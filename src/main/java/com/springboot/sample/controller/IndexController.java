package com.springboot.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	// dispatch / to /web
	@RequestMapping("/")
	public String showIndex() {
		return "web/index.html";
	}
}
