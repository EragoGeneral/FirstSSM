package com.demo.mybatis.inter;

import java.util.List;

import com.demo.mybatis.model.SystemMenus;

public interface IMenuOperation {
	
	public List<SystemMenus> querySystemMenus();
}
