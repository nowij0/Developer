package com.developer.userreview;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class UserReviewDAOOracle implements UserReviewDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserReviewDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	@Override
	public void addUserReivew(UserReviewVO vo) throws FindException {
		// TODO Auto-generated method stub
		
	}	
}
