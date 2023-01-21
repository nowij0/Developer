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
	 * @return 
	 * @throws FindException
	 */
	public int joinUser(UsersVO vo) throws FindException;
	
	
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
	public int updateUsers(UsersVO vo) throws FindException;
	
	/**
	 * [일반회원: 첫 화면] 회원 정보 출력
	 * @author Jin
	 * @param 로그인한 userId
	 * @return userId로 검색한 UsersVO 객체 반환
	 * @throws FindException
	 */
	public UsersVO getUsers(String userId) throws FindException;

	
	/**
	 * @author Jin
	 * @param 탈퇴할 userId
	 * @throws FindException
	 */
	public void deleteUser(String userId) throws FindException;
	
}
