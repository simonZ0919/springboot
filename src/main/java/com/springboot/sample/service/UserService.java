package com.springboot.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sample.entity.User;
import com.springboot.sample.mapper.UserMapper;
import com.springboot.sample.service.ex.PasswordNotMatchExcetption;
import com.springboot.sample.service.ex.UserNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserMapper mapper;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return user data
	 * @throws UserNotFoundException username incorrect
	 * @throws PasswordNotMatchExcetption password incorrect
	 */
	public User login(String username, String password) 
			throws UserNotFoundException, PasswordNotMatchExcetption{
		User data=findByUsername(username);
		if (data==null) {
			throw new UserNotFoundException("username not found");
		} else {
			if(data.getPassword().equals(password)) {
				return data;
			}else {
				throw new PasswordNotMatchExcetption("password incorrect");
			}
		}
	}
	
	private User findByUsername(String username) {
		return mapper.findByUsername(username);
	}
}
