package com.developer.users;

import java.util.List;

import com.developer.appliedlesson.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.hostuser.HostUserVO;
import com.developer.lesson.LessonVO;
import com.developer.lessonreview.LessonReviewVO;

public interface UsersDAO {
	
	/**
	 * <관리자 : 일반회원 전체목록 페이지>회원 목록 출력
	 * @author choigeunhyeong
	 * @return 회원테이블 전체값
	 * @throws FindException
	 */
	public List<UsersVO> selectAll() throws FindException;
	
	/**
	 * <일반회원 : 로그인페이지> 로그인 하기위한 회원 검색 
	 * @author choigeunhyeong
	 * @param userId 로그인할 아이디
	 * @return userId로 검색한 UsersVO 객체 반환
	 * @throws FindException
	 */
	public UsersVO getUsers(String userId) throws FindException;
	
	/**
	 * <일반회원 : 아이디찾기 페이지> 일반 회원 아이디 찾기 
	 * @author choigeunhyeong
	 * @param email 입력할 이메일
	 * @return 입력받은 email과 일치하는 id값 userId
	 * @throws FindException
	 */
	public UsersVO selectUserId(String email) throws FindException;
	
	/**
	 * <일반회원 : 비밀번호찾기 페이지 >일반회원 비밀번호 찾기
	 * @author choigeunhyeong
	 * @param userId 입력할 아이디
	 * @param email 입력할 이메일
	 * @return 아이디와 이메일이 일치하는 녀석의 비밀번호 pwd
	 * @throws FindException
	 */
	public UsersVO selectUserPwd(String userId, String email) throws FindException;

	
	/**
	 * [일반회원 : 클래스 > 튜터] 튜터 클래스 정보 출력
	 * @author Jin
	 * @param 검색할 Lesson의 lessonSeq
	 * @return lessonSeq로 검색된 Lesson객체 하나 출력
	 * @throws FindException
	 */
	public LessonVO getLesson(int lessonSeq) throws FindException;
	

	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 신청튜티 목록
	 * 
	 * @param applyOk가 0이고
	 * @param 보여줄 lesson의 lessonSeq값
	 * @return 특정 lesson에 신청한 미승인 상태인 튜티 리스트 출력 
	 * @throws FindException
	 */
	public List<UsersVO> getLessonApplyUsers(int applyOk, int lessonSeq) throws FindException;
	
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 신청완료 튜티 목록
	 * 
	 * @param applyOk가 1인
	 * @param lessonSeq에 해당하는 lesson
	 * @return 해당 lesson의 applyOk가 1인 user리스트 출력
	 * @throws FindException
	 */
	public List<UsersVO> getLessonApplyOkUsers(int applyOk, int lessonSeq) throws FindException;
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 완료 클래스 > 상세 정보] 클래스 후기 목록 
	 * @author choigeunhyeong
	 * @param lessonSeq
	 * @param userId
	 * @return
	 * @throws FindException
	 */
	public List<LessonReviewVO> getLessonReview(int lessonSeq, String userId) throws FindException;
	
	//미승인 튜터 목록 출력
	//public List<UsersVO> selectTutor() throws FindException;
	
}
