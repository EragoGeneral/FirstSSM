package com.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.mybatis.model.Article;

public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {
	
	@Override
	public List<Article> getUserArticles(int userid) {
		return this.getSqlSession().selectList("com.demo.inter.IUserOperation.getUserArticles",userid);
	}
	
}
