package com.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.test.common.Constants;
import com.test.dao.BaseDao;
import com.test.domain.Order;

public class OrderServiceImpl implements OrderService {

	// 用户生成订单的时间格式
	private SimpleDateFormat timeFormat = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	// 基础DAO的引用
	private BaseDao baseDao;

	// 注入baseDao的setter方法
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	// 生成订单，订单号为当前的时间的年月日时分秒和毫秒
	public String generateOrder(Order order) {
		// 判断订单是否为空
		if (order == null)
			return null;
		// 用固定的时间格式生成订单，并把它保存进order对象里
		order.setOrderNum(timeFormat.format(new Date()));
		// 保存新订单
		baseDao.saveEntity(order);
		return order.getOrderNum();
	}

	// 获取所有的订单对象
	public List<Order> getAllOrder() {
		return baseDao.getAllEntity(Order.class);
	}

	// 通过订单ID来获取订单对象
	public Order getOrderById(Long id) {
		return baseDao.getEntityById(Order.class, id);
	}

	// 将订单的状态转到下一步
	public void nextOrderStatus(Long id) {
		// 首先，通过DAO获取Order对象
		Order order = baseDao.getEntityById(Order.class, id);
		// 如果Order已经结束，则不用转到下一步
		if (order.getStatus() != Constants.ORDER_STATUS_END)
			;
		{
			order.setStatus(order.getStatus() + 1);
			baseDao.updateEntity(order);
		}
	}

}
