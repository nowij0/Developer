package com.developer.roomreview.dao;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.roomreview.vo.RoomReviewVO;

public interface RoomReviewDAO {
	/**
	 * [스터디카페 상세페이지 하단 후기리스트 페이지] 스터디룸 시퀀스를 받아 특정 스터디룸 후기에 대한 리스트를 출력한다
	 * @author ds
	 * @param srSeq 스터디카페 시퀀스(장소번호) 
	 * @return List<RoomReviewVO> 특정스터디카페 후기 리스트
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */

	public List<RoomReviewVO> selectAll(int srSeq) throws FindException;
	
	/**
	 * [마이페이지 스터디카페 후기페이지] 유저 아이디로 작성한 이용후기 목록을 출력한다
	 * @author ds
	 * @param userId 유저아이디 
	 * @return List<RoomReviewVO> 유저의 작성한 이용후기 전체목록
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<RoomReviewVO> selectMyRmRv(String userId) throws FindException;
	

	/**
	 * [마이페이지 스터디카페 후기페이지] 예약시퀀스를 받아 해당 예약의 후기를 전체출력한다
	 * @author ds
	 * @param resSeq 예약 시퀀스
	 * @return RoomReviewVO 유저의 작성한 이용후기 상세정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public RoomReviewVO selectMyRmRvDetail(int resSeq) throws FindException;
	
	/**
	 * [마이페이지 스터디카페 후기페이지] 아이디값으로 후기를 작성하지 않은 예약리스트를 출력한다
	 * @author ds
	 * @param resSeq 예약 시퀀스
	 * @return List<RoomReviewVO> 유저의 작성한 이용후기 리스트
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<RoomReviewVO> selectMyReqRmRv(String userId) throws FindException;
	
	

	/**
	 * [마이페이지 스터디카페 후기페이지] 작성된 후기를 DB에 insert한다
	 * @author ds
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public void insertRmRv(String content, int star, int resSeq) throws FindException;
	

}
