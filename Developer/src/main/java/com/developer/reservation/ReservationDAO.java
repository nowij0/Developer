package com.developer.reservation;

import java.util.Date;
import java.util.List;

import com.developer.exception.FindException;


public interface ReservationDAO {
	/**
	 * <스터디카페 예약페이지>
	 * @author ds
	 * 룸 시퀀스와 예약일을 받아 이미 예약된 예약정보에 대한 리스트를 출력한다
	 * 예약테이블 외 필요한 것
	 * roomInfo 테이블의 price
	 * @param roomSeq 스터디룸 시퀀스,  usingDate 예약일 
	 * @return 특정일자의 해당 스터디룸 예약정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<ReservationVO> selectAllByUsingDate(int roomSeq, Date usingDate) throws FindException;
	/**
	 * <스터디카페 예약페이지>
	 * @author ds
	 * 예약정보를 예약테이블에 넣어 예약내역에 insert
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public void insertRv() throws FindException;
	/**
	 * <마이페이지 스터디카페 예약내역 페이지>
	 * @author ds
	 * 아이디값을 받아와 전체 예약내역을 최신순으로 출력한다
	 * 예약테이블 외 필요한 것
	 * studyroom 테이블의 name => srName
	 * roominfo 테이블의 name => rifName
	 * @param userId 유저 아이디 
	 * @return 유저의 전체 예약 내역(최신순) 
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<ReservationVO>  selectMyResHistory(String userId) throws FindException;
	
	/**
	 *<마이페이지 스터디카페 예약내역 페이지>
	 * @author ds
	 * 예약을 취소. 예약내역을 예약테이블에서 delete. sysdate기준 이후(미래) 예약만 가능
	 * @param resSeq 예약시퀀스 
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public void deleteRv(int resSeq) throws FindException;

	/**
	 * [마이페이지-호스트] 스터디'카페' 정보 수정버튼을 누르기 전에 예약 내역이 있는지 없는지를 확인한다.
	 * @author sr
	 * @param HostId(호스트 아이디)
	 * @return List<ReservationVO>
	 * @throws FindException
	 */
	public List<ReservationVO> studycafeReservationCheck(String hostId) throws FindException;
	
	
	/**
	 * [마이페이지-호스트] 스터디'룸' 정보 수정버튼을 누르기 전에 예약내역이 있는지 없는지를 확인한다.
	 * @author sr
	 * @param roomSeq
	 * @return List<ReservationVO>
	 * @throws FindException
	 */
	public List<ReservationVO> studyroomReservationCheck(int roomSeq) throws FindException;
	
	
	/**
	 * [마이페이지-호스트] 스터디카페 예약 내역을 전체 출력(목록)한다.
	 * @author sr
	 * @return List<ReservationVO>
	 * @throws FindException
	 */
	public List<ReservationVO> selectAll() throws FindException;
	
	
	/**
	 * [마이페이지-호스트] 스터디카페 예약 상세내용을 출력한다.
	 * @author sr
	 * @param resSeq
	 * @return ReservationVO
	 * @throws FindException
	 */
	public ReservationVO select(int resSeq) throws FindException;
	
	
	/**
	 * [마이페이지-호스트] 스터디카페 예약을 취소(삭제)한다.
	 * @author sr
	 * @param resSeq
	 * @throws FindException
	 */
	public void delete(int resSeq) throws FindException; 

	
}
