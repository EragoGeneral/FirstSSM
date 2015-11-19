package com.demo.mybatis.model;

import java.util.Date;
import java.util.List;

public class SystemMenus {

	private int ID;
	private String name;
	private String link;
	private int displayOrder;
	private int parentID;
	private int level;
	private String path;
	private String isDeteled;
	private int createBy;
	private Date createDate;
	private int updateBy;
	private Date updateDate;	
	private List<SystemMenus> children;
	
	public SystemMenus(){
		
	}
	
	public SystemMenus(int iD, String name, String link, int displayOrder,
			int parentID, int level, String path, String isDeteled,
			int createBy, Date createDate, int updateBy, Date updateDate) {
		super();
		this.ID = iD;
		this.name = name;
		this.link = link;
		this.displayOrder = displayOrder;
		this.parentID = parentID;
		this.level = level;
		this.path = path;
		this.isDeteled = isDeteled;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIsDeteled() {
		return isDeteled;
	}
	public void setIsDeteled(String isDeteled) {
		this.isDeteled = isDeteled;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<SystemMenus> getChildren() {
		return children;
	}
	public void setChildren(List<SystemMenus> children) {
		this.children = children;
	}
}
