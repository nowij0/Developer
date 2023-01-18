package com.developer.roominfo;

import java.util.List;

import com.developer.exception.FindException;


public interface RoomInfoDAO {
	/**
	 * <스터디카페 정보 출력페이지>
	 * @author ds
	 * 스터디룸 시퀀스를 받아 스터디룸의 전체정보를 출력한다
	 * @param srSeq 스터디카페 시퀀스(장소번호) 
	 * @return 특정스터디카페 전체정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<RoomInfoVO> selectAll(int srSeq) throws FindException;


public interface RoomInfoDAO {

	/**
	 * [마이페이지-호스트] 스터디카페의 스터디룸정보를 등록한다.
	 * @author sr
	 * @param roomInfoVO 
	 * @throws FindException
	 */
	public void insert(RoomInfoVO roomInfoVO) throws FindException;
	
	
	/**
	 * [마이페이지-호스트] 스터디룸 목록을 전체 출력한다
	 * @author sr
	 * @param hostId
	 * @return List<RoomInfoVO>
	 * @throws FindException
	 */
	public List<RoomInfoVO> selectAll(String hostId) throws FindException; 
	
	/**
	 *[마이페이지-호스트] 스터디룸 정보를 수정한다.
	 * @author sr
	 * @param roomInfoVO
	 * @throws FindException
	 */
	public void update(RoomInfoVO roomInfoVO) throws FindException;
	
	
	/**
	 * [마이페이지-호스트] 스터디룸 정보를 삭제한다.
	 * @author sr 
	 * @param roomSeq
	 * @throws FindException
	 */
	public void delete(int roomSeq) throws FindException;
	
	
	/**
	 *[마이페이지-호스트] 스터디룸 정보 1set을 출력한다.
	 * @author sr
	 * @param roomSeq
	 * @return RoomInfoVO
	 * @throws FindException
	 */
	public RoomInfoVO select(int roomSeq) throws FindException; 
	
	
}
