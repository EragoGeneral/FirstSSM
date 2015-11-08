package com.demo.dao;

import java.util.List;

import com.demo.mybatis.model.Article;

public interface UserDAO {
	public List<Article> getUserArticles(int userid);
}
