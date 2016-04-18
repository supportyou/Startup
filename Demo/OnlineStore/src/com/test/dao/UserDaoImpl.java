package com.test.dao;

import java.util.List;

import com.test.domain.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	// 登录验证，如果失败返回null
		public User loginCheck(String name, String password) {
			// 定义HQL语句
			String hql = "from User u where u.name=? and u.password=?";
			// 用find方法执行HQL语句
			List<User> list = this.getHibernateTemplate().find(hql, new String[] { name, password });
			if (list != null && list.size() > 0) {// 登录成功
				logger.info("login check succ, user.name=" + list.get(0).getName());
				return list.get(0);
			} else {// 登录失败
				return null;
			}
		}
}
