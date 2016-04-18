package com.test.service;

import java.util.List;

import com.test.dao.BaseDao;
import com.test.domain.Product;

public class ProductServiceImpl implements ProductService {

	//基础DAO的引用
		private BaseDao baseDao;
		//注入baseDao的setter方法
		public void setBaseDao(BaseDao baseDao) {
			this.baseDao = baseDao;
		}
		//根据商品id获取商品对象
		public Product getProduct(long productId) {
			return baseDao.getEntityById(Product.class, productId);
		}
		//获取所有的商品
		public List<Product> getAllProducts() {
			return baseDao.getAllEntity(Product.class);
		}
}
