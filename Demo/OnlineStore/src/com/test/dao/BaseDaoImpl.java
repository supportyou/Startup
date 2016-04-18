package com.test.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

	// 定义一个Logger，便于它及其子类计入日志用
		protected Logger logger = Logger.getLogger(this.getClass());

		// 删除实体
		public <T> void deleteEntity(T entity) {
			this.getHibernateTemplate().delete(entity);
		}

		// 根据实体类型和ID删除实体
		public <T> void deleteEntityById(Class<T> entityClass, Serializable id) {
			this.getHibernateTemplate().delete(entityClass.getName(), id);
		}

		// 查询某个实体的全部实例
		public <T> List<T> getAllEntity(Class<T> entityClass) {
			return this.getHibernateTemplate().find("from " + entityClass.getName());
		}

		// 通过主键获取实体
		public <T> T getEntityById(Class<T> entityClass, Serializable id) {
			return (T) this.getHibernateTemplate().get(entityClass, id);
		}

		// 保存实体
		public <T> void saveEntity(T entity) {
			this.getHibernateTemplate().saveOrUpdate(entity);
		}

		// 修改实体
		public <T> void updateEntity(T entity) {
			this.getHibernateTemplate().saveOrUpdate(entity);
		}
}
