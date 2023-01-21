package com.developer.reservation;

import java.util.List;
import com.developer.exception.FindException;

public interface ReservationDAO {

	
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
	public List<ReservationVO> selectAllStudycafeReservation(String hostId) throws FindException;
	
}
