package com.test.dao.test;

import org.hibernate.Session;

import com.test.domain.User;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		s.beginTransaction();
		//List<User> list = s.createQuery("from User").list();
		User user = new User("test002","123");
		s.save(user);
		s.getTransaction().commit();
		s.close();
	}
}
