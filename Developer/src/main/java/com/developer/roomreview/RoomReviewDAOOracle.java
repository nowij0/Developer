package com.developer.roomreview;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;


public class RoomReviewDAOOracle implements RoomReviewDAO {
	private SqlSessionFactory sqlSessionFactory;
	public RoomReviewDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
}
