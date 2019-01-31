package com.alphaomega.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alphaomega.demo.dao.UserMapper;
import com.alphaomega.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlphaApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Test
	public void testCheckUser() throws Exception{
		User u = userMapper.getUsersByPhoneNo("18610783383");
		System.out.println("test userMapper=========");
		System.out.println(u.getUsername());
	}


}
