package com.alphaomega.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alphaomega.demo.annotation.UnCheckTokenString;
import com.alphaomega.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	private Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;

	@UnCheckTokenString
	@RequestMapping(value="login",method=RequestMethod.POST,produces="application/jason;charset=UTF-8")
	public String login(@RequestBody String params) {
		
		JSONObject json = JSONObject.parseObject(params);
		String phoneno = json.getString("phoneno");
		String password = json.getString("password");
		log.info("phoneno=" + phoneno + ",password=" + password);

		
		return userService.checkUser(phoneno, password);
	}
}
