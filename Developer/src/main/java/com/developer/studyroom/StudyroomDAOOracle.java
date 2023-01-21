package com.developer.studyroom;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;


public class StudyroomDAOOracle implements StudyroomDAO {
	private SqlSessionFactory sqlSessionFactory;
	public StudyroomDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
}
