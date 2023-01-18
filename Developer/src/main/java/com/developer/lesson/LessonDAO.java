package com.developer.lesson;

import java.util.Date;
import java.util.List;

import java.util.List;

import com.developer.exception.FindException;

public interface LessonDAO {
	

	/**
	 * [클래스 메인화면] 카테고리별 클래스 목록 출력 
	 * @author moonone
	 * @param payLesson 유료클래스여부 (0무료 1유료 2결제대기)
	 * @param endCdate 수업종료일  
	 * @param filter 필터 선택값 
	 * @param starAvg [튜터정보]의 평균별점 
	 * @return 검색한 클래스에 대한 정보 
	 */
	public List<LessonVO> selectLesson(int payLesson, Date endCdate, int filter, int starAvg);
	
	/**
	 * [클래스 메인화면] 클래스이름, 카테고리, 튜터명으로 검색 목록 출력 
	 * @author moonone
	 * @param lessonName 클래스명 
	 * @param category 카테고리 
	 * @param name [회원]의 튜터이름 
	 * @return 검색한 클래스에 대한 정보 
	 */
	public List<LessonVO> selectSearch(String lessonName, int category, String name);
		
	/**
	 * [클래스] 선택한 클래스에 대한 상세정보 
	 * @author moonone
	 * @param lessonSeq 클래스번호 
	 * @return 해당하는 클래스 정보
	 */
	public LessonVO selectDetail(int lessonSeq);
	
	/**
	 * [클래스] 클래스 등록 
	 * @param lessonSeq 클래스번호 
	 * @param userId 튜터아이디 
	 * @param lessonName 클래스명 
	 * @param category 카테고리 
	 * @param content 상세내용 
	 * @param people 클래스정원 
	 * @param imgPath 이미지
	 * @param startCDate 수업시작일 
	 * @param endCDate 수업종료일 
	 * @param price 가격 
	 * @param startDate 신청시작일 
	 * @param endDate 신청종료일 
	 * @param payLesson 유료클래스 여부 
	 * @param location 수업지역 
	 */
	public void addLesson(LessonVO lessonVO);
	
	/**
	 * [마이페이지] 튜티 : 대시보드 
	 * @author moonone
	 * @param userId 회원아이디 
	 * @return 수업이름, 승인여부
	 */
	public List<LessonVO> selectDashBoard(String userId);
	
	/**
	 * [마이페이지] 튜티 : 나의 후기 목록 확인  
	 * @author moonone
	 * @param userId 회원아이디 
	 * @return 수업명, 후기, 별점 
	 */
	public List<LessonVO> selectReview(String userId);

	
	/**
	 * [메인] 날짜가 임박한순으로 수업 전체 목록을 출력한다.
	 * @author sr
	 * @return List<LessonVO>
	 * @throws FindException
	 */
	public List<LessonVO> selectAllByDate() throws FindException; 


}
