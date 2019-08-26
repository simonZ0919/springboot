package com.springboot.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sample.entity.User;
import com.springboot.sample.mapper.UserMapper;
import com.springboot.sample.service.ex.PasswordNotMatchExcetption;
import com.springboot.sample.service.ex.UserNotFoundException;
import com.springboot.sample.service.ex.DuplicateKeyException;
import com.springboot.sample.service.ex.InsertException;

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
	
	/**
	 * 
	 * @param user
	 * @return registered user
	 * @throws DuplicateKeyException
	 * @throws InsertException
	 */
	public User reg(User user) throws DuplicateKeyException,InsertException {
		User data=findByUsername(user.getUsername());
		if (data==null) {// name not used
			addNew(user);
			return user;
		} else {// if name has been used
			throw new DuplicateKeyException(
					"username: "+user.getUsername()+" has been used");
		}
	}
	
	private User findByUsername(String username) {
		return mapper.findByUsername(username);
	}
	
	private void addNew(User user) {
		Integer rows=mapper.addNew(user);
		if(rows !=1) {
			throw new InsertException("unknown database error");
		}
	}
}
