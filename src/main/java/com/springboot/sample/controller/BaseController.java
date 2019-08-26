package com.springboot.sample.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.sample.entity.ResponseResult;
import com.springboot.sample.service.ex.DuplicateKeyException;
import com.springboot.sample.service.ex.InsertException;
import com.springboot.sample.service.ex.PasswordNotMatchExcetption;
import com.springboot.sample.service.ex.ServiceException;
import com.springboot.sample.service.ex.UserNotFoundException;

public abstract class BaseController{
	protected static final int SUCCESS = 1;
	
	@ExceptionHandler(ServiceException.class)
	public ResponseResult handleException(Exception e) {
		if(e instanceof UserNotFoundException) {
			return new ResponseResult(2,e);
		}else if (e instanceof PasswordNotMatchExcetption) {
			return new ResponseResult(3,e);
		}else if (e instanceof DuplicateKeyException) {
			return new ResponseResult(4,e);
		}else if (e instanceof InsertException) {
			return new ResponseResult(5,e);
		}
		
		return null;
	}
	
}
