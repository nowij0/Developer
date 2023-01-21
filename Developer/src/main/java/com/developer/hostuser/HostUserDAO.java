package com.developer.hostuser;

import java.util.List;

import com.developer.exception.FindException;

public interface HostUserDAO {
	
	/**
	 * [관리자 페이지] 호스트회원 전체목록 출력 
	 * @author choigeunhyeong
	 * @return 호스트회원 테이블 전체값
	 * @throws FindException
	 */
	public List<HostUserVO> selectAll() throws FindException;
	
	/**
	 * [호스트회원 > 로그인] 호스트로그인을 위한 호스트회원 검색
	 * @author choigeunhyeong
	 * @return 호스트회원 테이블 아이디값에 해당하는 정보
	 * @throws FindException
	 */
	public HostUserVO hostLogin(String hostId) throws FindException;
	
	/**
	 * [호스트회원 > 아이디찾기 페이지] 호스트회원 사업자번호로 아이디 검색
	 * @author choigeunhyeong
	 * @param num 사업자 번호
	 * @return 사업자번호값이 일치하는 호스트회원의 아이디
	 * @throws FindException
	 */
	public HostUserVO selectHostId(String num) throws FindException;
	
	/**
	 * [호스트회원 > 비밀번호 찾기 페이지] 호스트회원아이디, 사업자번호, 이메일이 일치하는 값의 비밀번호 검색
	 * @author choigeunhyeong
	 * @param hostId 호스트회원 아이디
	 * @param num 사업자번호
	 * @param email 이메일
	 * @return
	 * @throws FindException
	 */
	public HostUserVO selectHostPwd(String hostId, String num, String email) throws FindException;
	
	
}
