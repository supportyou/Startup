package com.test.service;

import java.util.List;

import com.test.domain.Product;

public interface ProductService {

	// 根据商品id获取商品对象
	public Product getProduct(long productId);

	// 获取所有的商品
	public List<Product> getAllProducts();
}
