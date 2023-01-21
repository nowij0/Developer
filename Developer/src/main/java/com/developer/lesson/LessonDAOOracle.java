package com.developer.lesson;

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
	
	
	
}
