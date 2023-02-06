package com.developer.lesson.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.dto.PageBean;
import com.developer.exception.FindException;
import com.developer.lesson.vo.LessonVO;
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
	
	//지원
	@Override
	public PageBean<LessonVO> selectLesson(int category, int priceFilter, int starFilter, int currentPage) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("category", category);
		map.put("priceFilter", priceFilter);
		map.put("starFilter", starFilter);
		map.put("currentPage", currentPage);
		PageBean<LessonVO> selectLesson = (PageBean<LessonVO>) session.selectList("com.developer.lesson.selectLesson", map);
		session.commit();
		session.close();
		return selectLesson;
	}

	public static void main(String[] args) throws FindException {
		LessonDAOOracle dao = new LessonDAOOracle();
		List<LessonVO> list = dao.selectSearch("자바");
		for(LessonVO vo : list) {
			System.out.println(vo);
		}
	}
	
	//지원 : 제목 검색은 가능, 중첩 검색은 아직 
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
	public List<LessonVO> selectDetail(int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<LessonVO> selectDetail = session.selectList("com.developer.lesson.selectDetail", lessonSeq);
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
	
	//sr
	@Override
	public List<LessonVO> selectAllByDate() throws FindException {
			SqlSession session = sqlSessionFactory.openSession();
			List<LessonVO> list = session.selectList("com.developer.lesson.selectAllByDate");
			session.close();
			return list;
	}

}
