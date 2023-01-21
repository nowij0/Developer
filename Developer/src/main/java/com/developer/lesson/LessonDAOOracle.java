package com.developer.lesson;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class LessonDAOOracle implements LessonDAO {

	private SqlSessionFactory sqlSessionFactory;
	public LessonDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	
	
	//sr
	@Override
	public List<LessonVO> selectAllByDate() throws FindException {
			SqlSession session = sqlSessionFactory.openSession();
			List<LessonVO> list = session.selectList("com.developer.lesson.selectAllByDate");
			session.close();
			return list;
	}

}
