package com.developer.studyroom;

import com.developer.exception.FindException;

public interface StudyroomDAO {
	/**
	 * [마이페이지-호스트] 스터디카페 예약을 오픈한다.
	 * @author sr
	 * @param StudyroomVO
	 * @throws FindException
	 */
	public void reservationOpen(StudyroomVO studyroomVO) throws FindException;

	/**
	 * [마이페이지-호스트] 스터디카페 예약을 마감한다.
	 * @author sr
	 * @param StudyroomVO
	 * @throws FindException
	 */
	public void reservationClose(StudyroomVO studyroomVO) throws FindException;

	/**
	 * [마이페이지-호스트] 스터디카페 정보 1set을 출력한다.
	 * @author sr
	 * @param hostId
	 * @return StudyroomVO
	 * @throws FindException
	 */
	public StudyroomVO select(String hostId) throws FindException;
	
	/**
	 * [마이페이지-호스트] 스터디카페 정보를 수정한다.
	 * @author sr
	 * @param studyroomVO
	 * @throws FindException
	 */
	public void update(StudyroomVO studyroomVO) throws FindException;
 
	
	/**
	 * [호스트회원 가입 - 이메일인증] 스터디카페를 등록(추가)한다.
	 * @author sr
	 * @param studyroomVO
	 * @throws FindException 
	 */
	public void insert(StudyroomVO studyroomVO) throws FindException;
	
	
	
	
}
