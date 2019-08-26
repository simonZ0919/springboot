package com.springboot.sample.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.springboot.sample.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("select id, password from t_user where username=#{username}")
	User findByUsername(String username);
	
	@Insert("insert into t_user(username, password, age, phone, email, department)"
			+ "values(#{username},#{password},#{age},#{phone},#{email},#{department})")
	// get primary key
	@Options(useGeneratedKeys = true, keyProperty = "id")
	Integer addNew(User user);
}
