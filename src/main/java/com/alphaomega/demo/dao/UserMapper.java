package com.alphaomega.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.alphaomega.demo.domain.User;

public interface UserMapper {

	@Select("select * from user where phoneno = #{phoneNo} order by userid desc")
	User getUsersByPhoneNo(@Param("phoneNo")String phoneNo);
}
