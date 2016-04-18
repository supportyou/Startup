package com.test.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Cart {

	// 定义一个Logger，便于它及其子类计入日志用
		private Logger logger = Logger.getLogger(this.getClass());
		// 包含的项目，产品id为key
		private Map<Long, Item> items = new HashMap<Long, Item>();
		private Double price;
		// 添加商品到购物车
		public void addItem(Product product, int number) {
			if(items.containsKey(product.getId()))
				return;
			Item item = new Item(product, number);
			items.put(product.getId(), item);
		}

		// 修改商品数量
		public void modifyNumberByProductId(Long productId, int number) {
			Item item = items.get(productId);
			item.setNumber(number);
		}

		// 删除商品项目
		public void deleteItemByProductId(Long productId) {
			items.remove(productId);
		}

		// 删除多个商品项目
		public void deleteItemByProductId(Long[] productIds) {
			for (Long id : productIds) {
				items.remove(id);
			}
		}

		// 清空购物车
		public void clear() {
			items.clear();
			logger.info("Cart cleared. size=" + items.size());
		}

		// 获取所有的项目
		public Map<Long, Item> getCartItems() {
			return items;
		}

		// 获取购物车项目的数量
		public int getItemNumber() {
			return items.size();
		}

		// 判断购物车是否为空
		public boolean isEmpty() {
			return items.isEmpty();
		}
		
		//购物车所有商品项的总价
		public Double getPrice() {
			double sum = 0;
			for(Long id : items.keySet()){
				Item item = items.get(id);
				sum += item.getCost();
			}
			return sum;
		}

		// setters and getters
		public Map<Long, Item> getItems() {
			return items;
		}

		public void setItems(Map<Long, Item> items) {
			this.items = items;
		}
}
