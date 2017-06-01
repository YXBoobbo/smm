package com.example.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.mapper.UserMapper;
import com.example.model.User;

public class TestMyBatis {

	public static void main(String[] args) throws IOException {
		//装在mybatis-config.xml配置文件
		InputStream inputStream=Resources.getResourceAsStream("mybatis-config.xml");
		
		//获得SqlSession
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		
		//获得UserMapper （及DAO）
		UserMapper userMapper=session.getMapper(UserMapper.class);
		
		//新建User对象
		User user=new User();
		user.setName("name1");
		user.setContactInfo("contact_info1");
		
		//向数据库插入新建的User对象并提交事务。
		userMapper.insert(user);
		session.commit();
	}

}
