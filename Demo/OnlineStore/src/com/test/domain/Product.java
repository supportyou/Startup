package com.test.domain;

public class Product {

	private Long id; // 主键
	private String name;// 商品名称
	private String description;// 商品描述
	private String imageSrc;// 图片地址
	private Double price;//价格

	// 默认的无参构造方法
	public Product() {
		super();
	}

	// 需要传递商品名称的构造方法
	public Product(String name) {
		super();
		this.name = name;
	}
	// setters and getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
