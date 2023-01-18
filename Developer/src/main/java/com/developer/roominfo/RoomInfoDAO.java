package com.developer.roominfo;

import java.util.List;

import com.developer.exception.FindException;

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
