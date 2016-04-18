package com.test.service;

import com.test.domain.User;

public interface UserService {

	//用户登录方法
	public User login(String name,String password);
}
