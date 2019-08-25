package com.springboot.sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springboot.sample.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("select id, password from t_user where username=#{username}")
	User findByUsername(String username);
}
