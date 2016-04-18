package com.test.dao.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.common.Constants;
import com.test.dao.BaseDao;
import com.test.domain.Item;
import com.test.domain.Order;
import com.test.domain.Product;
import com.test.domain.User;
import com.test.service.OrderService;

public class OrderTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseDao baseDao = (BaseDao) ac.getBean("baseDao");
		OrderService orderService = (OrderService) ac.getBean("orderService");
		
		User user = baseDao.getEntityById(User.class, (long)1);
		Product p1 = baseDao.getEntityById(Product.class, (long)1);
		Product p2 = baseDao.getEntityById(Product.class, (long)2);
		
		Item item1 = new Item();
		item1.setProduct(p1);
		item1.setNumber(2);
		item1.setCost(item1.getNumber() * p1.getPrice());
		
		Item item2 = new Item();
		item2.setProduct(p2);
		item2.setNumber(1);
		item2.setCost(item2.getNumber() * p2.getPrice());
		
		Map<Long, Item> items = new HashMap<Long, Item>();
		items.put(p1.getId(), item1);
		items.put(p2.getId(), item2);
		
		Order order = new Order(Constants.ORDER_STATUS_POST,user);
		item1.setOrder(order);
		item2.setOrder(order);
		order.setItems(items);
		
		orderService.generateOrder(order);
		
	}
	
}
