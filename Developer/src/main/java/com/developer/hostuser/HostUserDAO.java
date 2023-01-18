package com.developer.hostuser;

import com.developer.exception.FindException;

public interface HostUserDAO {

	/**
	 * [마이페이지-호스트] 호스트 회원의 정보 1 set를 출력한다 (+스터디카페 정보 1set도 같이 출력)
	 * @author sr
	 * @param hostId(호스트 아이디)
	 * @return HostUserVO
	 * @throws FindException
	 */
	public HostUserVO select(String hostId) throws FindException;
	
	/**
	 * [마이페이지-호스트] 호스트 회원 정보를 수정한다
	 * @author sr
	 * @param HostUserVO
	 * @throws FindException
	 */
	public void update(HostUserVO hostUserVO) throws FindException;
	
	/**
	 * [마이페이지-호스트] 호스트 회원을 삭제한다(탈퇴)
	 * @author sr
	 * @param HostId(호스트 아이디)
	 * @throws FindException
	 */
	public void delete(String hostId) throws FindException;
	
	
}
