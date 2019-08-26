package com.springboot.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sample.entity.ResponseResult;
import com.springboot.sample.entity.User;
import com.springboot.sample.service.UserService;
import com.springboot.sample.service.ex.PasswordNotMatchExcetption;
import com.springboot.sample.service.ex.UserNotFoundException;

@RestController
public class UserController extends BaseController {
	
	@Autowired
	private UserService service;
	@RequestMapping("/login.do")
	public ResponseResult login(String username, String password,
			HttpSession session) {
		ResponseResult rr;
		User user=service.login(username, password);
		session.setAttribute("uid", user.getId());
		return new ResponseResult(SUCCESS);
	}
	
	@RequestMapping("/reg.do")
	public ResponseResult reg(User user) {
		service.reg(user);
		return new ResponseResult(SUCCESS);
	}
	
}
