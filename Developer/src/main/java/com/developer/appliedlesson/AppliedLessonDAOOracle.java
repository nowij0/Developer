package com.developer.appliedlesson;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;

public class AppliedLessonDAOOracle implements AppliedLessonDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public AppliedLessonDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	
}
