package com.alphaomega.demo.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alphaomega.demo.service.SerialService;
import com.alphaomega.demo.service.UserService;
import com.alphaomega.demo.utils.CommonUtils;
import com.alphaomega.demo.utils.JwtUtil;
import com.alphaomega.demo.constant.Constant;
import com.alphaomega.demo.dao.UserMapper;
import com.alphaomega.demo.domain.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public String checkUser(String phoneNo, String password) {
		
		//创建返回Json结果
		JSONObject returnJson = new JSONObject();		
       
		//验证用户名密码不能为空
		if(StringUtils.isEmpty(phoneNo)) {
			returnJson.put("flg", Constant.FAIL_FLG);
			returnJson.put("message", "账号不能为空");

			return returnJson.toJSONString();
		}		
		if(StringUtils.isEmpty(password)) {
			returnJson.put("flg", Constant.FAIL_FLG);
			returnJson.put("message", "密码不能为空");
			
			return returnJson.toJSONString();
		}
		
		//验证用户是否存在
		User user = getUserByPhoneNo(phoneNo);
		if(user == null) {
			returnJson.put("flg", Constant.FAIL_FLG);
			returnJson.put("message", "账号不存在，请验证账号是否输入正确");
			
			return returnJson.toJSONString();
		}
		
		//验证用户密码
		String md5Password = CommonUtils.Md5(password);
		if(!md5Password.equals(user.getPassword())) {
			returnJson.put("flg", Constant.FAIL_FLG);
			returnJson.put("message", "密码不正确");
			
			return returnJson.toJSONString();
		}
		
		//生成JWT的token
		String userId = String.valueOf(user.getUserid());
		String token = JwtUtil.createJWT(phoneNo, userId);
		
		//redis
		//TO DO...
		
		//start serial
		SerialService.start();
		
		return userInfoForLogin(token, user);
	}

	@Override
	public User getUserByPhoneNo(String phoneNo) {
		
		User user = userMapper.getUsersByPhoneNo(phoneNo);
		if(user != null) {
			return user;
		}
		
		return null;
	}
	
	private String userInfoForLogin(String token, User user) {
		JSONObject json = new JSONObject();
		json.put("token", token);
		json.put("userid", user.getUserid().toString());
		json.put("type", user.getPermissionid().toString());
		json.put("permissionId", user.getPermissionid());
		json.put("flg", Constant.SUCCESS_FLG);
		json.put("message", "");
		
		return json.toJSONString();
	}

}
