package com.developer.lesson;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.lessonreivew.LessonReviewVO;

public interface LessonDAO {

	/**
	 * [클래스: 메인화면] 현재 진행 중인 수업 목록 (필터로 정렬)
	 * 
	 * @author moonone
	 * 
	 * @return List<LessonVO>
	 * @throws FindException
	 */
	public List<LessonVO> selectLesson(int category, int filter) throws FindException;
<<<<<<< HEAD
=======
	
			
>>>>>>> 353c77f68bacf11d6a9cdb28022fbf674fba9dfc

	/**
	 * [클래스: 메인화면] 수업 이름, 카테고리명, 강사명 검색
	 * 
	 * @author moonone
	 * @param search 검색어
	 * @return 해당하는 클래스 정보
	 * @throws FindException
	 */
	public List<LessonVO> selectSearch(String search) throws FindException;

	/**
	 * [클래스: 상세정보] 선택한 클래스에 대한 상세정보
	 * 
	 * @author moonone
	 * @param lessonSeq 클래스번호
	 * @return 해당하는 클래스 정보 + 평균별점
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
	public LessonVO selectDetail(int lessonSeq) throws FindException;

	/**
	 * [클래스: 상세정보] 선택한 클래스를 개설한 튜터의 후기 목록 (필터로 정렬)
	 * 
	 * @author moonone
	 * @param lessonSeq 해당수업번호
	 * @return 수업에 해당하는 후기내역들
	 * @throws FindException
	 */
	public List<LessonVO> selectAllReview(int lessonSeq) throws FindException;

	/**
	 * [클래스] 클래스 등록
	 * 
	 * @author moonone
	 * @param lessonSeq  클래스번호
	 * @param userId     튜터아이디
	 * @param lessonName 클래스명
	 * @param category   카테고리
	 * @param content    상세내용
	 * @param people     클래스정원
	 * @param imgPath    이미지
	 * @param startCDate 수업시작일
	 * @param endCDate   수업종료일
	 * @param price      가격
	 * @param startDate  신청시작일
	 * @param endDate    신청종료일
	 * @param payLesson  유료클래스 여부
	 * @param location   수업지역
	 * @throws FindException
	 */
	public void addLesson(LessonVO lessonVO) throws FindException;

	/**
	 * [클래스: 상세정보] 튜터가 생성한 클래스목록 + 튜터 정보
	 * 
	 * @author moonone
	 * @param userId 튜터아이디
	 * @return 튜터가 생성한 수업 목록 + 튜터 정보
	 * @throws FindException
	 */
	public List<LessonVO> selectTutor(String userId) throws FindException;

	/**
	 * [마이페이지] 튜티 : 대시보드
	 * 
	 * @author moonone
	 * @param userId 회원아이디
	 * @return 수업이름, 승인여부
	 */
	public List<LessonVO> selectDashBoard(String userId) throws FindException;

<<<<<<< HEAD
	/**
	 * [메인] 날짜가 임박한순으로 수업 전체 목록을 출력한다.
	 * 
	 * @author sr
	 * @return List<LessonVO>
	 * @throws FindException
	 */
	public List<LessonVO> selectAllByDate() throws FindException;
=======
	
>>>>>>> 353c77f68bacf11d6a9cdb28022fbf674fba9dfc

}
