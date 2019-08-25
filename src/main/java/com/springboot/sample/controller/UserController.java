package com.springboot.sample.controller;

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
	public ResponseResult login(String username, String password) {
		ResponseResult rr;
		User user=service.login(username, password);
		rr=new ResponseResult(SUCCESS);

		return rr;
	}
}
