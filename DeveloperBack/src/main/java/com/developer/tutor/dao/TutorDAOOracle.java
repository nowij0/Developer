package com.developer.tutor.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;
import com.developer.tutor.vo.TutorVO;

public class TutorDAOOracle implements TutorDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public TutorDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	//지원
	@Override
	public void addTutor(TutorVO tutorVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.selectOne("com.developer.tutor.insertTutor", tutorVO);
		session.commit();
		session.close();
	}

}
