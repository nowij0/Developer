package com.developer.studyroom;

import java.util.List;

import com.developer.exception.FindException;

public interface StudyroomDAO {
	/**
	 * <스터디카페 검색페이지>
	 * @author ds
	 * 스터디카페명, 주소로 스터디카페리스트를 검색한다
	 * 스터디카페 테이블 외 필요한 것 
	 * roominfo의 person, price 
	 * fav-studyroom테이블의userId 
	 * @param search1 스터디카페명, 주소명 
	 * @return 검색에 맞은 스터디카페목록
	 * @throws 스터디카페목록 검색시 FindException예외발생한다
	 */
	public List<StudyroomVO> selectBySerch1(String search1) throws FindException;
	
	/**
	 * <스터디카페 검색페이지>
	 * @author ds
	 * 사람수로 스터디카페리스트를 검색한다
	 * 스터디카페 테이블 외 필요한 것 
	 * roominfo의 person, price 
	 * fav-studyroom테이블의 userId 
	 * order by 두개있음
	 * @param perosn 인원수 
	 * @return 검색에 맞은 스터디카페목록
	 * @throws 스터디카페목록 검색시 FindException예외발생한다
	 */
	
	public List<StudyroomVO> selectByPerson(int person) throws FindException;
	
	/**
	* <스터디카페 검색페이지>
	 * @author ds
	 * 주소와 인원수로 스터디카페리스트를 검색한다
	 * order by 두개있음
	 * @param addr 스터디카페 주소, person 인원 수 
	 * @return 검색에 맞은 스터디카페목록
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<StudyroomVO> selectByAddrAndPerson(String addr, int person) throws FindException;
	
	
	/**
	 * <스터디카페의 모든정보를 출력하는 상세페이지>
	 * @author ds
	 * 스터디룸 시퀀스를 받아 스터디카페의 전체정보를 출력한다
	 * @param srSeq 스터디카페 시퀀스(장소번호) 
	 * @return 특정스터디카페 전체정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<StudyroomVO> selectAll(int srSeq) throws FindException;

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


