package com.demo.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.demo.mybatis.inter.IUserOperation;
import com.demo.mybatis.model.Article;
import com.demo.mybatis.model.User;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		IUserOperation userOperation=session.getMapper(IUserOperation.class);
		try {
			user = (User) session.selectOne(
					"com.demo.mybatis.inter.IUserOperation.selectUserByID", 2);
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserName());
            user = userOperation.selectUserByID(1);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }
		
		SqlSession session1 = sqlSessionFactory.openSession();
		IUserOperation userOperation1=session1.getMapper(IUserOperation.class);
		try {
			//getUserList("%T%");
			
	        //addUser();
			
			//user = userOperation1.selectUserByID(3);            
	        //user.setUserAddress("tianjin, nankai");
			//updateUser(user);
			
			//deleteUser(3);
	        
			getUserArticles(1);
		}finally{
			session.close();
		}
	}
	
	public static void getUserList(String userName){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);           
            List<User> users = userOperation.selectUsers(userName);
            for(User user:users){
                System.out.println(user.getId()+":"+user.getUserName()+":"+user.getUserAddress());
            }
            
        } finally {
            session.close();
        }
    }
	
	/**
     * ��������,���Ӻ󣬱����ύ���񣬷��򲻻�д�뵽��ݿ�.
     */
    public static void addUser(){
        User user=new User();
        user.setUserAddress("xi'an,xianning");
        user.setUserName("Rock");
        user.setUserAge(26);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("��ǰ���ӵ��û� idΪ:"+user.getId());
        } finally {
            session.close();
        }
    }
    
    public static void updateUser(User user){
        //�ȵõ��û�,Ȼ���޸ģ��ύ��
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            userOperation.updateUser(user);
            session.commit();            
        } finally {
            session.close();
        }
    }
    
    /**
     * ɾ����ݣ�ɾ��һ��Ҫ commit.
     * @param id
     */
    public static void deleteUser(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);           
            userOperation.deleteUser(id);
            session.commit();            
        } finally {
            session.close();
        }
    }
    
    public static void getUserArticles(int userid){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);           
            List<Article> articles = userOperation.getUserArticles(userid);
            for(Article article:articles){
                System.out.println(article.getTitle()+":"+article.getContent()+
                        ":������:"+article.getUser().getUserName()+":��ַ:"+
                         article.getUser().getUserAddress());
            }
        } finally {
            session.close();
        }
    }
}