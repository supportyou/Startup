package com.test.dao;

import com.test.domain.User;

public interface UserDao {

	/// 登录验证，如果失败返回null
	public User loginCheck(String name, String password);
}
