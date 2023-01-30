package com.developer.users.dao;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.users.vo.UsersVO;

public interface UsersDAO {

	/**
	 * <관리자 : 일반회원 전체목록 페이지>회원 목록 출력
	 * 
	 * @author choigeunhyeong
	 * @return 회원테이블 전체값
	 * @throws FindException
	 */
	public List<UsersVO> selectAll() throws FindException;
	
	/**
	 * <일반회원 : 로그인페이지> 로그인 하기위한 회원 검색
	 * 
	 * @author choigeunhyeong
	 * @param userId 로그인할 아이디
	 * @return userId로 검색한 UsersVO 객체 반환
	 * @throws FindException
	 */
	public UsersVO userLogin(String userId, String pwd) throws FindException;
	
	/**
	 * <일반회원 : 아이디찾기 페이지> 일반 회원 아이디 찾기
	 * 
	 * @author choigeunhyeong
	 * @param email 입력할 이메일
	 * @return 입력받은 email과 일치하는 id값 userId
	 * @throws FindException
	 */
	public UsersVO selectUserId(String email) throws FindException;

	/**
	 * <일반회원 : 비밀번호찾기 페이지 >일반회원 비밀번호 찾기
	 * 
	 * @author choigeunhyeong
	 * @param userId 입력할 아이디
	 * @param email  입력할 이메일
	 * @return 아이디와 이메일이 일치하는 녀석의 비밀번호 pwd
	 * @throws FindException
	 */
	public UsersVO selectUserPwd(String userId, String email) throws FindException;


	/**
	 * [회원가입 > 회원] 회원가입
	 * 
	 * @author Jin
	 * @param 회원가입 할 일반회원 객체 생성
	 * @return
	 * @throws FindException
	 */
	public int joinUsers(UsersVO vo) throws FindException;

	/**
	 * [일반회원: 첫 화면] 회원 정보 수정
	 * 
	 * @author Jin
	 * @param 일반회원 객체의 정보를 수정
	 * @throws FindException
	 */
	public int updateUsers(UsersVO vo) throws FindException;

	/**
	 * [일반회원: 첫 화면] 회원 정보 출력
	 * 
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
	public void deleteUsers(String userId) throws FindException;

	/**
	 * @author Jin
	 * @return 튜터 리스트
	 * @throws FindException
	 */
	public List<UsersVO> selectTutor() throws FindException;

}
