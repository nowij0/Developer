package com.developer.lesson;

import java.text.ParseException;
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

	//장학
	@Override
	public LessonVO selectDetail(int lessonSeq) {
		SqlSession session = sqlSessionFactory.openSession();
		LessonVO vo = (LessonVO) session.selectOne("com.developer.lesson.selectDetail", lessonSeq);
		return vo;
	}
	
	//장학
	@Override
	public List<LessonVO> getLessonByUser1(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<LessonVO> list = session.selectList("com.developer.lesson.getLessonByUser1", userId);
		session.close();
		return list;

	}

	//장학
	@Override
	public List<LessonVO> getLessonByUser2(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<LessonVO> list = session.selectList("com.developer.lesson.getLessonByUser2", userId);
		session.close();
		return list;

	}

	//장학
	@Override
	public List<LessonVO> getLessonByUser3(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<LessonVO> list = session.selectList("com.developer.lesson.getLessonByUser3", userId);
		session.close();
		return list;

	}	

	//장학
	@Override
	public void updateLesson(LessonVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("com.developer.lesson.updateLesson", vo);
		session.commit();
		session.close();
		
	}

	//장학
	@Override
	public void deleteLesson(int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.developer.lesson.deleteLesson",lessonSeq);
		session.commit();
		session.close();
	}


	public static void main(String[] args) throws FindException, ParseException {
		LessonDAOOracle dao = new LessonDAOOracle();
		LessonVO vo = new LessonVO();
//		dao.deleteLesson(9);
//		vo = dao.selectDetail(5);
		System.out.println(dao.selectDetail(5));
		
//		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-mm-dd");
//		Date sdate = dateForm.parse("2023-04-15");
//		Date edate = dateForm.parse("2023-05-16");
		
//		java.sql.Date sdate = java.sql.Date.valueOf("2023-04-15");
//		java.sql.Date edate = java.sql.Date.valueOf("2023-06-15");
//		vo.setLessonSeq(9);
//		vo.setCategory("5");
//		vo.setLocation("붕어빠아앙");
//		vo.setCategory("5");
//		vo.setPeople(222);
//		vo.setContent("자바로 오세요");
//		vo.setStartCdate(sdate);
//		vo.setEndCdate(edate);
//		dao.updateLesson(vo);
//		System.out.println(vo);
		
		
		
		
//		List<LessonVO> list = dao.getLessonByUser3("devman2");
//		for(LessonVO v : list) {
//		System.out.println(v);
//		}
	}


	
	
	
}
