package com.springboot.sample;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDigest {
	
	@Test
	public void commonsEncrypt() {
		 System.out.println(DigestUtils.sha512Hex("abc"));
	}
	
	
//	@Test
//	public void encrypt() {
//		String password="11";
//		String salt="aa";
//		// add salt to password
//		String src=salt+password+salt;
//		// encrypt with md5
//		System.out.println(
//				DigestUtils.md5DigestAsHex(src.getBytes()));
//	}
}
