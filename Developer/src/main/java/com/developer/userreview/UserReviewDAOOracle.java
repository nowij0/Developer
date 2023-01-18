package com.developer.userreview;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;

public class UserReviewDAOOracle implements UserReviewDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserReviewDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	
}
