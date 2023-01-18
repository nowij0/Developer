package com.developer.users;

import java.util.List;

import com.developer.appliedlesson.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.hostuser.HostUserVO;
import com.developer.lesson.LessonVO;

public interface UsersDAO {
	
	//회원목록출력 
	public List<UsersVO> selectAll() throws FindException;
	
	//미승인 튜터 목록 출력
	public List<UsersVO> selectTutor() throws FindException;
	
	
	/**
	 * [회원가입 > 회원] 회원가입
	 * @author Jin
	 * @param 회원가입 할 일반회원 객체 생성
	 * @throws FindException
	 */
	public void joinUser(UsersVO vo) throws FindException;
	
	
	/**
	 * [회원가입 > 호스트] 호스트 회원가입
	 * @author Jin
	 * @param 호스트 회원가입 할 호스트객체 생성
	 * @throws FindException
	 */
	public void joinHostUser(HostUserVO vo) throws FindException;
	
	
	/**
	 * [일반회원: 첫 화면] 회원 정보 수정 
	 * @author Jin
	 * @param 일반회원 객체의 정보를 수정
	 * @throws FindException
	 */
	public void updateUsers(UsersVO vo) throws FindException;

	
	/**
	 * [일반회원: 첫 화면] 회원 정보 출력
	 * @author Jin
	 * @param 로그인한 userId
	 * @return userId로 검색한 UsersVO 객체 반환
	 * @throws FindException
	 */
	public UsersVO getUsers(String userId) throws FindException;
	
	
	/**
	 * [일반회원 : 클래스 > 튜터] 튜터 클래스 정보 출력
	 * @author Jin
	 * @param 검색할 Lesson의 lessonSeq
	 * @return lessonSeq로 검색된 Lesson객체 하나 출력
	 * @throws FindException
	 */
	public LessonVO getLesson(int lessonSeq) throws FindException;
	
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 수정하기
	 * 셀렉문은 getLesson메서드 쓰면 됨.
	 * @author Jin
	 * @param LessonVO의 수정할 값 입력 
	 * @throws FindException
	 */
	public void updateLesson(LessonVO vo) throws FindException;
	
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 삭제하기
	 * 
	 * @param 삭제할 lessonSeq값을 입력
	 * @throws FindException
	 */
	public void deleteLesson(int lessonSeq) throws FindException;
	
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
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 신청튜티 승인
	 * 
	 * @param 해당 튜티의 appliedLesson의 applyOk를 1로 변경
	 * @throws FindException
	 */
	public void updateApplyLesson(AppliedLessonVO vo) throws FindException;
	
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 신청튜티 거절
	 * 
	 * @param 해당 튜티의 appliedLesson의 applyOk를 2로 변경
	 * @throws FindException
	 */
	public void updateNotApplyLesson(AppliedLessonVO vo) throws FindException;
	
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 신청튜티 평가
	 * 
	 * @param 튜티에 해당하는 userId값
	 * @return 해당 튜티의 UsersVO 값 출력(이름, 리뷰, 평점)
	 * @throws FindException
	 */
	public UsersVO getTutee(String userId) throws FindException;
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 신청완료 튜티 목록
	 * 
	 * @param applyOk가 1인
	 * @param lessonSeq에 해당하는 lesson
	 * @return 해당 lesson의 applyOk가 1인 user리스트 출력
	 * @throws FindException
	 */
	public List<UsersVO> getLessonApplyOkUsers(int applyOk, int lessonSeq) throws FindException;
	
	
	
	
	
	
}
