package com.renxuan.mybatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import com.renxuan.mybatis.entity.SEX;
import com.renxuan.mybatis.entity.User;
import com.renxuan.mybatis.mapper.UserMapper;

public class Test {
	
	public static void main(String[]args) throws IOException {
		
		String resource ="conf.xml";
		//����mybatis�������ļ�
		Reader reader=Resources.getResourceAsReader(resource);
		
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader��"real");
		//������ִ�е�ʱ��ָ��environment
		//������ִ��ӳ���ļ���sql��sqlsession
		SqlSession session =sessionFactory.openSession();
		//ӳ��sql�ı�ʶ�ַ���
		
		String statement="com.renxuan.mybatis.mapper.UserMapper"+".selectUserById";
		//ִ�в�ѯ����һ��Ψһuser�����sql
		User user=session.selectOne(statement, 2);
		System.out.println("=====================��ѯ==================\n"+user);
		session.close();
		
		User aUser=new User(2,"two",23,SEX.FEMALE);
//		insertUser(aUser);
//		insertUser(new User(3,"three",3,SEX.MALE));
//		insertUser(new User(7,"three",4,SEX.UNKNOWN));
//		selectAllUser();
//		aUser.setName("newTwo");
//		updateUserById(aUser);
//		selectAllUser();
//		deleteUserById(10);
		selectAllUser();
		selectUserById(2);
		selectUserByIdWithConverter(3);
		selectUserByNameWithConverter("three");
		selectUserOrderByColumn("id");
		selectAllUserToHashMap();
	}
	public static void selectUserById(int id) throws IOException {
	
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.renxuan.mybatis.mapper.UserMapper"+".selectUserById";
		User user=session.selectOne(statement, id);
		System.out.println("=====================��ѯ==================\n"+user);	
		session.close();
	}
	public static void selectUserByIdWithConverter(int id) throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.renxuan.mybatis.mapper.UserMapper"+".selectUserByIdWithConverter";
		User user=session.selectOne(statement, id);
		System.out.println("=====================ת������ѯ==================\n"+user);	
		session.close();
	}
public static void selectUserOrderByColumn(String column) throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.renxuan.mybatis.mapper.UserMapper"+".selectUserOrderByColumn";
		List<User> user=session.selectList(statement, column);
		System.out.println("=====================�����ѯ==================\n"+user);	
		session.close();
	}
	public static void selectAllUser() throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.renxuan.mybatis.mapper.UserMapper"+".selectAllUser";
		List<Object> users=session.selectList(statement);
		System.out.println("=====================��ѯȫ��==================\n"+users);
		
		session.close();
	}
	public static void selectAllUserToHashMap() throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		UserMapper userMapper=session.getMapper(UserMapper.class);
		List<Map> users=userMapper.selectAllUserToHashMap();
		String statement="com.renxuan.mybatis.mapper.UserMapper"+".selectAllUserToHashMap";
//		List<Map> users=session.selectList(statement);
		System.out.println("=====================��ѯȫ��==================\n"+users);
		
		session.close();
	}
	public static void insertUser(User aUser) throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.renxuan.mybatis.mapper.UserMapper"+".insertUser";
		int cnt=session.insert(statement,aUser);
		System.out.println("=====================����==================\n"+aUser+"�������");	
		session.commit();
		session.close();
	}
public static void deleteUserById(int id) throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.renxuan.mybatis.mapper.UserMapper"+".deleteUserById";
		int cnt=session.delete(statement,id);
		System.out.println("=====================ɾ��==================\n"+"idΪ"+id+"��"+cnt+"��ɾ�����");	
		session.commit();
		session.close();
	}
public static void updateUserById(User aUser) throws IOException {
	
	Reader reader=Resources.getResourceAsReader("conf.xml");
	SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
	SqlSession session =sessionFactory.openSession();
	
	String statement="com.renxuan.mybatis.mapper.UserMapper"+".updateUserById";
	int cnt=session.update(statement,aUser);
	System.out.println("=====================�޸�==================\n"+aUser+"�޸����");	
	session.commit();
	session.close();
}
public static void selectUserByNameWithConverter(String name) throws IOException {
	
	Reader reader=Resources.getResourceAsReader("conf.xml");
	SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
	SqlSession session =sessionFactory.openSession();
	
	String statement="com.renxuan.mybatis.mapper.UserMapper"+".selectUserByNameWithConverter";
	List<User> user=session.selectList(statement, name);
	System.out.println("=====================ת����name��ѯ==================\n"+user);	
	session.close();
}
}
