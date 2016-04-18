package com.test.domain;

public class User {

	private Long id; // 主键
	private String name;// 用户名
	private String password;// 密码
	private String address;// 地址
	private String postCode;// 邮编
	private String email;// email地址
	private String homePhone;// 家庭电话号码
	private String cellPhone;// 手机号码
	private String officePhone;// 办公室电话号码

	// 默认的无参构造方法
	public User() {
		super();
	}

	// 需要传递用户名和密码的构造方法
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	
	
}
