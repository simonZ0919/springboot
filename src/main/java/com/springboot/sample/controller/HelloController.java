package com.springboot.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller + @ResponseBody
@RestController
public class HelloController {

	@GetMapping("/hello.do")
	public String testHello() {
		return "test OK";
	}
}
