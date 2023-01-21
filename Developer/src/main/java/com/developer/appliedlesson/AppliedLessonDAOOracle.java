package com.developer.appliedlesson;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class AppliedLessonDAOOracle implements AppliedLessonDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public AppliedLessonDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//지원 [미완]
	@Override
	public List<AppliedLessonVO> tuteeDashboard(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<AppliedLessonVO> tuteeDashboard = session.selectList("com.developer.appliedLesson.tuteeDashboard", userId);
		session.commit();
		session.close();
		return tuteeDashboard;
	}
	

}
