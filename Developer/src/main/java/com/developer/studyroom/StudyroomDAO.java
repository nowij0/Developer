package com.developer.studyroom;

import java.util.List;

import com.developer.exception.FindException;

public interface StudyroomDAO {
	/**
	 * [스터디카페 검색페이지] 주소(1), 스터디카페명(2)로 스터디카페리스트를 검색한다
	 * @author ds 
	 * @param searchSrNameAddr (주소명 or 스터디카페명 ) 
	 * order by 두개있음
	 * @return List<StudyroomVO> 검색에 맞은 스터디카페목록
	 * @throws 스터디카페목록 검색시 FindException예외발생한다
	 */
	public List<StudyroomVO> selectBySearchString(String srNameAddrName, int searchBy, int orderBy) throws FindException;
	
	/**
	 * [스터디카페 검색페이지] 인원수로 스터디카페리스트를 검색한다 order by 두개있음
	 * @author ds
	 * @param perosn 인원수 
	 * @return List<StudyroomVO> 검색에 맞은 스터디카페목록
	 * @throws 스터디카페목록 검색시 FindException예외발생한다
	 */
	
	public List<StudyroomVO> selectByPerson(int person, int orderBy) throws FindException;
	
	/**
	* [스터디카페 검색페이지] 주소와 인원수로 스터디카페리스트를 검색한다
	 * @author ds
	 * order by 두개있음
	 * @param addr 스터디카페 주소 
	 * @param person 인원 수 
	 * @return List<StudyroomVO> 검색에 맞은 스터디카페목록
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<StudyroomVO> selectByAddrAndPerson(String addr, int person, int orderBy) throws FindException;
	
	
	/**
	 * [스터디카페의 모든정보를 출력하는 상세페이지]스터디룸 시퀀스를 받아 특정 스터디카페의 전체정보를 출력한다
	 * @author ds
	 * @param srSeq 스터디카페 시퀀스(장소번호) 
	 * @return StudyroomVO 특정스터디카페 전체정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public StudyroomVO selectAllDetail(int srSeq) throws FindException;

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


