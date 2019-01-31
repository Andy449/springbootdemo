package com.alphaomega.demo.service;

import com.alphaomega.demo.domain.User;

public interface UserService {

	//验证登录用户信息
	public String checkUser(String phoneNo, String password);
	
	//根据手机号查询用户信息
	public User getUserByPhoneNo(String phoneNo);
}
