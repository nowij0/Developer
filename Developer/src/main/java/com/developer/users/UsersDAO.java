package com.developer.users;

import java.util.List;

import com.developer.exception.FindException;

public interface UsersDAO {
	
	//회원목록출력 
	public List<UsersVO> selectAll() throws FindException;
	
	//미승인 튜터 목록 출력
	public List<UsersVO> selectTutor() throws FindException;
	
	
	
	/**
	 * 로그인 하기위한 회원 검색
	 * @param userId 로그인할 아이디
	 * @return 아이디에 해당하는 상세정보
	 * @throws FindException
	 */
	public UsersVO getUsers(String userId) throws FindException;
	
	/**
	 * 일반 회원 아이디 찾기 
	 * @param email 입력할 이메일
	 * @return 입력받은 email과 일치하는 id값들 
	 * @throws FindException
	 */
	public List<UsersVO> selectUserId(String email) throws FindException;
	
	/**
	 * 일반회원 비밀번호 찾기
	 * @param userId 입력할 아이디
	 * @param email 입력할 이메일
	 * @return 아이디와 이메일이 일치하는 녀석의 비밀번호
	 * @throws FindException
	 */
	public UsersVO selectUserPwd(String userId, String email) throws FindException;
	
	
}
