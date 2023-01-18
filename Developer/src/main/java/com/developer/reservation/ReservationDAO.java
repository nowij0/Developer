package com.developer.reservation;

import java.util.List;

import com.developer.exception.FindException;

public interface ReservationDAO {
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
