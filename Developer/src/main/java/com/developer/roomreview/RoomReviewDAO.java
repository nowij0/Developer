package com.developer.roomreview;

import java.util.List;

import com.developer.exception.FindException;


public interface RoomReviewDAO {
	/**
	 * <스터디카페 정보 출력페이지>
	 * @author ds
	 * 스터디룸 시퀀스를 받아 스터디룸 후기에 대한 전체정보를 출력한다
	 * 후기테이블 외 필요한 것
	 * users 테이블의 nickname
	 * studyroom 테이블의 name => srName
	 * roominfo 테이블의 name => rifName
	 * @param srSeq 스터디카페 시퀀스(장소번호) 
	 * @return 특정스터디카페 후기 전체정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	//이 DAO에 select문마다 중복되어 추가로 생성하는 VO 
	public List<RoomReviewVO> selectAll(int srSeq) throws FindException;
	
	/**
	 * <마이페이지 스터디카페 후기페이지>
	 * @author ds
	 * 유저 아이디로 작성한 이용후기 목록을 출력한다
	 * 후기테이블 외 필요한 것
	 * studyroom 테이블 name=> srName
	 * roominfo 테이블 name => rifName
	 * @param userId 유저아이디 
	 * @return 유저의 작성한 이용후기 전체목록
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<RoomReviewVO> selectMyRmRv(int userId) throws FindException;
	

	/**
	 * <마이페이지 스터디카페 후기페이지>
	 * @author ds
	 * 예약시퀀스를 받아 해당 예약의 후기를 전체출력한다
	 * 후기테이블 외 필요한 것
	 * studyroom 테이블 name=> srName
	 * roominfo 테이블 name => rifName
	 * reservation 테이블 usingDate => VO로 대체
	 * @param resSeq 예약 시퀀스
	 * @return 유저의 작성한 이용후기 상세정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<RoomReviewVO> selectMyRmRvDetail(int resSeq) throws FindException;
	
	/**
	 * <마이페이지 스터디카페 후기페이지>
	 * @author ds
	 * 아이디값으로 후기를 작성하지 않은 예약리스트를 출력한다
	 * 후기테이블 외 필요한 것
	 * studyroom 테이블 name=> srName
	 * roominfo 테이블 name => rifName
	 * reservation 테이블 VO
	 * @param resSeq 예약 시퀀스
	 * @return 유저의 작성한 이용후기 상세정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<RoomReviewVO> selectMyRmRv(String userId) throws FindException;
	
	

	/**
	 * <마이페이지 스터디카페 후기페이지>
	 * @author ds
	 * 작성된 후기를 DB에 insert한다
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public void insertRmRv() throws FindException;
	

}
