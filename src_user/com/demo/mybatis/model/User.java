package com.demo.mybatis.model;

public class User {

	private int id;
	private String userName;
	private int userAge;
	private String userAddress;
	private String testAttr;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getTestAttr() {
		return testAttr;
	}

	public void setTestAttr(String testAttr) {
		this.testAttr = testAttr;
	}
}