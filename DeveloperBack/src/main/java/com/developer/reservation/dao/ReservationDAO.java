package com.developer.reservation.dao;

import java.util.Date;
import java.util.List;

import com.developer.exception.FindException;
import com.developer.reservation.vo.ReservationVO;

public interface ReservationDAO {
	/**
	 * [스터디카페 예약페이지] 룸 시퀀스와 예약일을 받아 이미 예약된 예약정보에 대한 리스트를 출력한다
	 * @author ds
	 * @param roomSeq 스터디룸 시퀀스
	 * @param usingDate 예약일 
	 * @return List<ReservationVO> 특정일자의 해당 스터디룸 예약정보
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<ReservationVO> selectAllByUsingDate(int roomSeq, Date usingDate) throws FindException;
	/**
	 * [스터디카페 예약페이지] 예약정보를 예약테이블에 넣어 예약내역에 insert
	 * @author ds
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public void insertRv(String userId, int roomSeq, String startTime, String endTime, Date usingDate) throws FindException;
	/**
	 * [마이페이지 - 스터디카페 예약내역 페이지] 아이디값을 받아와 전체 예약내역을 최신순으로 출력한다
	 * @author ds
	 * @param userId 유저 아이디 
	 * @return List<ReservationVO> 유저의 전체 예약 내역(최신순) 
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public List<ReservationVO>  selectMyResHistory(String userId) throws FindException;
	
	/**
	 *[마이페이지 - 스터디카페 예약내역 페이지] 예약을 취소. 예약내역을 예약테이블에서 delete. sysdate기준 이후(미래) 예약만 가능
	 * @author ds
	 * @param resSeq 예약시퀀스 
	 * @throws 전체정보 출력시  FindException예외발생한다
	 */
	
	public void deleteRv(int resSeq) throws FindException;

<<<<<<< HEAD:Developer/src/main/java/com/developer/reservation/ReservationDAO.java
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
	

	
	
=======

>>>>>>> de7ce6ca8146f5095cebcff606caca0cf6c4fe46:DeveloperBack/src/main/java/com/developer/reservation/dao/ReservationDAO.java
	/**
	 * [마이페이지-호스트] 스터디카페 예약 상세내용을 출력한다.
	 * @author sr
	 * @param resSeq
	 * @return ReservationVO 스터디카페 예약 상세내용
	 * @throws FindException
	 */
	public ReservationVO selectReservation(int resSeq) throws FindException;
	
	
	/**
	 * [마이페이지-호스트] 스터디카페 예약을 취소(삭제)한다.
	 * @author sr
	 * @param resSeq 예약번호
	 * @throws FindException
	 */
	public int reservationDelete(int resSeq) throws FindException; 
	
	/** 
	 * [마이페이지-호스트] 스터디카페 예약 내역을 전체 출력(목록)한다.
	 * @author sr
	 * @param hostId
	 * @return List<ReservationVO>
	 * @throws FindException
	 */
	public List<ReservationVO> selectAllReservation(String hostId) throws FindException;
	
	
}
