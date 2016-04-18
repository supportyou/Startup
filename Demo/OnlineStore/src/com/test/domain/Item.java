package com.test.domain;

public class Item {

	private Long id; // 主键
	private Integer number;// 商品数量
	private Product product;// 商品类
	private Double cost;//总价
	private Order order;// 所属订单

	// 默认的无参构造方法
	public Item() {
		super();
	}

	// 需要传递商品类型及其数量的构造方法
	public Item(Product product, Integer amount) {
		super();
		this.product = product;
		this.number = amount;
	}

	// setters and getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getCost() {
		return number * product.getPrice();
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}
