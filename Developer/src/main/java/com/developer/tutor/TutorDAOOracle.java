package com.developer.tutor;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;
import com.developer.users.UsersVO;

public class TutorDAOOracle implements TutorDAO {
<<<<<<< HEAD
	
=======

	private SqlSessionFactory sqlSessionFactory;
	
	public TutorDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public static void main(String[] args) throws FindException {
		TutorDAOOracle dao = new TutorDAOOracle();
		
		TutorVO tutorVO = new TutorVO();
		tutorVO.setUserId("devman");
		tutorVO.setInfo("튜터등록테스트");
		tutorVO.setImgPath("...");
		System.out.println("==시작==");
		dao.addTutor(tutorVO);
		System.out.println(tutorVO);
		System.out.println("==끝==");
	}
	
	@Override
	public void addTutor(TutorVO tutorVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.selectOne("com.developer.tutor.insertTutor", tutorVO);
		session.commit();
		session.close();
	}


>>>>>>> 24016e656d39b0bdcea57683fe473175c58dd951
}
