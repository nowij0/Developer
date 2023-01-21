package com.developer.roominfo;

<<<<<<< HEAD
public interface RoomInfoDAO {

=======
import java.util.List;

import com.developer.exception.FindException;


public interface RoomInfoDAO {
	/**
	 * [마이페이지-호스트] 스터디카페의 스터디룸정보를 등록한다.
	 * @author sr 
	 * @param roomInfoVO 스터디룸정보
	 * @throws FindException
	 */
	public void insertRoom(RoomInfoVO roomInfoVO) throws FindException;
	
	 
	
	
	/** 
	 *[마이페이지-호스트] 스터디룸 정보를 수정한다.
	 * @author sr
	 * @param roomInfoVO
	 * @throws FindException
	 */
	public int updateRoom(RoomInfoVO roomInfoVO) throws FindException;
	
	
	/**
	 * [마이페이지-호스트] 스터디룸 정보를 삭제한다.
	 * @author sr 
	 * @param roomSeq
	 * @throws FindException
	 */
	public int deleteRoom(int roomSeq) throws FindException;
	
	
	/**
	 *[마이페이지-호스트] 스터디룸 정보 1set을 출력한다.
	 * @author sr
	 * @param roomSeq       
	 * @return RoomInfoVO
	 * @throws FindException
	 */
	public RoomInfoVO getRoom(int roomSeq) throws FindException; 

	
>>>>>>> 24016e656d39b0bdcea57683fe473175c58dd951
}
