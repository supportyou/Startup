package com.test.service;

import java.util.List;

import com.test.domain.Order;

public interface OrderService {

	// 生成订单
	public String generateOrder(Order order);

	// 获取所有的订单
	public List<Order> getAllOrder();

	// 通过订单的ID获取订单对象
	public Order getOrderById(Long id);

	// 将订单的状态转到下一步
	public void nextOrderStatus(Long id);

}
