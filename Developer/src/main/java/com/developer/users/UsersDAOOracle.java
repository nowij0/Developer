package com.developer.users;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;

public class UsersDAOOracle implements UsersDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UsersDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	
  


}

	




