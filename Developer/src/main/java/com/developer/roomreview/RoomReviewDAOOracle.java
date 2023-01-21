package com.developer.roomreview;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;

public class RoomReviewDAOOracle implements RoomReviewDAO {

	private SqlSessionFactory sqlSessionFactory;
	public RoomReviewDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	
}
