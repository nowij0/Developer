package com.developer.hostuser;

import com.developer.exception.FindException;

public interface HostUserDAO {

	/**
	 * [마이페이지-호스트] 호스트 회원 정보를 수정한다
	 * @author sr
	 * @param HostUserVO
	 * @throws FindException
	 */
	public int updateHostUser(HostUserVO hostUserVO) throws FindException;
	
	/**
	 * [마이페이지-호스트] 호스트 회원을 삭제한다(탈퇴)
	 * @author sr
	 * @param hostId(호스트 아이디)
	 * @throws FindException
	 */
	public int deleteHostUser(String hostId) throws FindException;
	
	/**
	 * [마이페이지-호스트] 호스트 회원 정보를 출력한다.
	 * @author sr
	 * @param hostId (호스트아이디)
	 * @return HostUserVO
	 * @throws FindException
	 */
	public HostUserVO getHostUser(String hostId) throws FindException;
	
}
