package com.developer.lesson.service;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.lesson.dao.LessonDAO;
import com.developer.lesson.dao.LessonDAOOracle;
import com.developer.lesson.vo.LessonVO;

public class LessonService {

	LessonDAOOracle dao = new LessonDAOOracle();

	// [JW] 선택한 클래스에 대한 상세정보
	public List<LessonVO> selectDetail(int lessonSeq) throws FindException {
		List<LessonVO> selectDetail = dao.selectDetail(lessonSeq);
		return selectDetail;
	};

	// [JW] 클래스를 개설한 튜터의 후기 목록
	public List<LessonVO> selectAllReview(int lessonSeq) throws FindException {
		List<LessonVO> selectAllReview = dao.selectAllReview(lessonSeq);
		return selectAllReview;
	}

	// [JW] 튜터가 생성한 클래스목록 + 튜터 정보
	public List<LessonVO> selectTutor(String userId) throws FindException {
		List<LessonVO> selectTutor = dao.selectTutor(userId);
		return selectTutor;
	}

	// [JW] 현재 진행 중인 수업 목록 > 카테고리 검색까지는 가능, 필터는 아직 
	public List<LessonVO> selectLesson(int category, int priceFilter, int starFilter) throws FindException {
		List<LessonVO> selectLesson = dao.selectLesson(category, priceFilter , starFilter);
		return selectLesson;
	}

	// [JW] 수업 이름, 카테고리명, 강사명 검색 > 제목 검색은 가능
	public List<LessonVO> selectSearch(String search) throws FindException {
		List<LessonVO> selectSearch = dao.selectSearch(search);
		return selectSearch;
	}

	// [JW] 수업 등록
	public void addLesson(LessonVO lessonVO) throws FindException {
		dao.addLesson(lessonVO);
	}

	// sr: 메인페이지 대시보드 임박순 출력
	public List<LessonVO> listLessonByDate() throws FindException {
		LessonDAO dao = new LessonDAOOracle();
		return dao.selectAllByDate();
	}
	
	//JH
	public LessonVO selectLessonDetail(int lessonSeq) throws FindException {
		return dao.selectLessonDetail(lessonSeq);
	}
	
	//JH
	public List<LessonVO> getLessonByUser1(String userId) throws FindException {
		return dao.getLessonByUser1(userId);
	}
	
	//JH
	public List<LessonVO> getLessonByUser2(String userId) throws FindException {
		return dao.getLessonByUser2(userId);
	}
	
	//JH
	public List<LessonVO> getLessonByUser3(String userId) throws FindException {
		return dao.getLessonByUser3(userId);
	}
	
	//JH
	public void updateLesson(LessonVO vo) throws FindException {
		dao.updateLesson(vo);
	}
	
	//JH
	public void deleteLesson(int lessonSeq) throws FindException {
		dao.deleteLesson(lessonSeq);
	}

}
