package com.developer.lesson;

<<<<<<< HEAD

public class LessonDAOOracle implements LessonDAO {
=======
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public LessonVO selectLessonDetail(int lessonSeq) {
		SqlSession session = sqlSessionFactory.openSession();
		LessonVO vo = (LessonVO) session.selectOne("com.developer.lesson.selectLessonDetail", lessonSeq);
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
	
	//지원 : 카테고리 검색까지는 가능, 필터는 XXX
	@Override
	public List<LessonVO> selectLesson(int category, int filter) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("category", category);
		map.put("filter", filter);
		List<LessonVO> selectLesson = session.selectList("com.developer.lesson.selectLesson", map);
		session.commit();
		session.close();
		return selectLesson;
	}

	//지원 : 제목 검색은 가능, 중첩 검색은 XXX
	@Override
	public List<LessonVO> selectSearch(String search) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<LessonVO> selectSearch = session.selectList("com.developer.lesson.selectSearch", search);
		session.commit();
		session.close();
		return selectSearch;
	}

	//지원 
	@Override
	public LessonVO selectDetail(int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		LessonVO selectDetail = session.selectOne("com.developer.lesson.selectDetail", lessonSeq);
		session.commit();
		session.close();
		return selectDetail;
	}

	//지원
	@Override
	public List<LessonVO> selectAllReview(int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<LessonVO> selectAllReview = session.selectList("com.developer.lesson.selectAllReview", lessonSeq);
		session.commit();
		session.close();
		return selectAllReview;
	}

	//지원
	@Override
	public void addLesson(LessonVO lessonVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.selectList("com.developer.lesson.addLesson", lessonVO);
		session.commit();
		session.close();
	}

	//지원 
	@Override
	public List<LessonVO> selectTutor(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<LessonVO> selectTutor = session.selectList("com.developer.lesson.selectTutor", userId);
		session.commit();
		session.close();
		return selectTutor;
	}
	
	//지원 [미완]
	@Override
	public List<LessonVO> selectDashBoard(String userId) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 24016e656d39b0bdcea57683fe473175c58dd951
	
	//sr
	@Override
	public List<LessonVO> selectAllByDate() throws FindException {
			SqlSession session = sqlSessionFactory.openSession();
			List<LessonVO> list = session.selectList("com.developer.lesson.selectAllByDate");
			session.close();
			return list;
	}

}
