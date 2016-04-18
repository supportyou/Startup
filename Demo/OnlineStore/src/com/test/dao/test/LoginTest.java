package com.test.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.UserDao;

public class LoginTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println(userDao.loginCheck("admin", "123"));
		System.out.println(userDao.loginCheck("throne212", "123"));
	}
}
