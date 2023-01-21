package com.developer.studyroom;

import java.util.List;

import com.developer.exception.FindException;

public interface StudyroomDAO {

	/**
	 * [마이페이지-호스트] 스터디카페 예약을 오픈한다.
	 * @author sr
	 * @param StudyroomVO
	 * @throws FindException
	 */
	public int reservationOpen(String hostId) throws FindException;

	/**
	 * [마이페이지-호스트] 스터디카페 예약을 마감한다.
	 * @author sr
	 * @param StudyroomVO
	 * @throws FindException
	 */
	public int reservationClose(String hostId) throws FindException;

	/**
	 * [마이페이지-호스트] 스터디카페 정보 1set을 출력한다.
	 * @author sr
	 * @param  hostId
	 * @return StudyroomVO
	 * @throws FindException
	 */
	public StudyroomVO getStudycafe (String hostId) throws FindException;
	
	/**
	 * [마이페이지-호스트] 스터디카페 정보를 수정한다.
	 * @author sr
	 * @param studyroomVO
	 * @throws FindException
	 */
	public int updateStudycafe(StudyroomVO studyroomVO) throws FindException;
 
	
	/**
	 * [호스트회원 가입 - 이메일인증] 스터디카페를 등록(추가)한다.
	 * @author sr
	 * @param studyroomVO
	 * @throws FindException 
	 */
	public void insertStudycafe(StudyroomVO studyroomVO) throws FindException;
	
	
	//sr_seq 때문에 원래는 룸인포DAO에 넣었는데 이동함.
	/**
	 * [마이페이지-호스트] 스터디룸 목록을 전체 출력한다
	 * @author sr
	 * @param hostId
	 * @return List<RoomInfoVO> 스터디룸목록
	 * @throws FindException
	 */
	public List<StudyroomVO> selectAllRoom(String hostId) throws FindException; 
	
	/**
	 * [마이페이지-호스트] 호스트 회원의 정보 1 set + 스터디카페 정보 1set를 출력한다
	 * @author sr
	 * @param hostId(호스트 아이디)
	 * @return HostUserVO
	 * @throws FindException
	 */
	public StudyroomVO getHostAndStudyroom(String hostId) throws FindException;

}


