package com.demo.mybatis.model;

public class Product {
	private String productid;
	private String productname;
	private float unitcost;
	private String status;
	private float listprice;
	private String attr1;
	private String itemid;
	
	public Product(String productid, String productname, float unitcost,
			String status, float listprice, String attr1, String itemid) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.unitcost = unitcost;
		this.status = status;
		this.listprice = listprice;
		this.attr1 = attr1;
		this.itemid = itemid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public float getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(float unitcost) {
		this.unitcost = unitcost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getListprice() {
		return listprice;
	}
	public void setListprice(float listprice) {
		this.listprice = listprice;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	
	
}
