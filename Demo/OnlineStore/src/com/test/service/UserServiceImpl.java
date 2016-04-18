package com.test.service;

import com.test.dao.UserDao;
import com.test.domain.User;

public class UserServiceImpl implements UserService {

	//引用用户DAO
		private UserDao userDao;
		//依赖注入的setter方法
		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		//登录方法的实现
		public User login(String name, String password) {
			return userDao.loginCheck(name, password);
		}
}
