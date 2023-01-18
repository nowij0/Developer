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
}
