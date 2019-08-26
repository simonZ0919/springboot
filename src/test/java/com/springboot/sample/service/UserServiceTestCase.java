package com.springboot.sample.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.sample.entity.User;
import com.springboot.sample.service.ex.PasswordNotMatchExcetption;
import com.springboot.sample.service.ex.ServiceException;
import com.springboot.sample.service.ex.UserNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {
	@Autowired
	private UserService service;
	
	@Test
	public void login() {
		try {
			String username="spring1";
			String password="1234";
			System.out.println(service.login(username, password));
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (PasswordNotMatchExcetption e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void reg() {
		try {
			User user=new User();
			user.setUsername("spring1");
			user.setPassword("123");
			System.out.println(service.reg(user));
		} catch (ServiceException e) {
			System.out.println(e.getClass()+":"+e.getMessage());
		}
	}
	
}
