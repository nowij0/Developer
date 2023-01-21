package com.developer.lesson;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.lessonreivew.LessonReviewVO;

public interface LessonDAO {
	
			
	/**
	 * [클래스] 선택한 클래스에 대한 상세정보 
	 * @author moonone
	 * @param lessonSeq 클래스번호 
	 * @return 해당하는 클래스 정보
	 */
	public LessonVO selectDetail(int lessonSeq);


	/**
	 * [일반회원 : 클래스 > 튜터] 진행예정 클래스 정보 출력
	 * @author Jin
	 * @param 튜터에 해당하는 userId
	 * @return UserId로 검색된 Lesson 리스트 출력
	 * @throws FindException
	 */
	public List<LessonVO> getLessonByUser1(String userId) throws FindException;
	
	/**
	 * [일반회원 : 클래스 > 튜터] 진행중클래스 정보 출력
	 * @author Jin
	 * @param 튜터에 해당하는 userId
	 * @return UserId로 검색된 Lesson 리스트 출력
	 * @throws FindException
	 */
	public List<LessonVO> getLessonByUser2(String userId) throws FindException;
	
	/**
	 * [일반회원 : 클래스 > 튜터] 진행완료 클래스 정보 출력
	 * @author Jin
	 * @param 튜터에 해당하는 userId
	 * @return UserId로 검색된 Lesson 리스트 출력
	 * @throws FindException
	 */
	public List<LessonVO> getLessonByUser3(String userId) throws FindException;
	
	
	
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 수정하기
	 * 셀렉문은 getLessonByUser메서드 사용.
	 * @author Jin
	 * @param LessonVO의 수정할 값 입력 
	 * @throws FindException
	 */
	public void updateLesson(LessonVO vo) throws FindException;
	
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 삭제하기
	 * @author Jin
	 * @param 삭제할 lessonSeq값을 입력
	 * @throws FindException
	 */
	public void deleteLesson(int lessonSeq) throws FindException;
	

	

}
