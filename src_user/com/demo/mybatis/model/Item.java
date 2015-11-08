package com.demo.mybatis.model;

public class Item {
	private int itemID;
	private String itemCode;
	private String itemName;	
	
	public Item() {
		super();
	}
	
	public Item(String itemCode, String itemName) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
}
