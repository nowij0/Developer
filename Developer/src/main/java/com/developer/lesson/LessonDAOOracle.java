package com.developer.lesson;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;

public class LessonDAOOracle implements LessonDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public LessonDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	
	
	
	
}
