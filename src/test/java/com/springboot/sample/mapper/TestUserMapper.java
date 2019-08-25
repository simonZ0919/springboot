package com.springboot.sample.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper {
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void findByUsername() {
		System.out.println(mapper.findByUsername("admin"));
	}
}
