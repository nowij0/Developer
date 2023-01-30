package com.developer.reservation.service;

import java.util.Date;
import java.util.List;

import com.developer.exception.FindException;
import com.developer.reservation.dao.ReservationDAO;
import com.developer.reservation.dao.ReservationDAOOracle;
import com.developer.reservation.vo.ReservationVO;

public class ReservationService {
	//sr: 호스트 마이페이지(예약내역 목록)
	public List<ReservationVO> getAllReservation(String hostId) throws FindException{
		ReservationDAO dao = new ReservationDAOOracle();
		return dao.selectAllReservation(hostId);
	}
	
	//sr: 호스트 마이페이지(예약내역상세)
	public ReservationVO infoReservation(int resSeq) throws FindException{
		ReservationDAO dao = new ReservationDAOOracle();
		return dao.selectReservation(resSeq);
	}
	
	//sr: 호스트 마이페이지(예약내역삭제)
	public int delReservation(int resSeq) throws FindException{
		ReservationDAO dao = new ReservationDAOOracle();
		int a = dao.reservationDelete(resSeq);
		return a;
	}
	//ds
		public List<ReservationVO> selectAllByUsingDate(int roomSeq, Date usingDate)throws FindException{
			ReservationDAO dao;
			dao = new ReservationDAOOracle();
			List<ReservationVO> list = dao.selectAllByUsingDate(roomSeq, usingDate);
			return list;
			
		}
		//ds
		public List<ReservationVO>  selectMyResHistory(String userId) throws FindException{
			ReservationDAO dao;
			dao = new ReservationDAOOracle();
			List<ReservationVO> list = dao.selectMyResHistory(userId);
			return list;
			
			
		}
		//ds
		public void insertRv(String userId, int roomSeq, String startTime, String endTime, Date usingDate) throws FindException {
			ReservationDAO dao;
			dao = new ReservationDAOOracle();
			dao.insertRv(userId, roomSeq, startTime, endTime, usingDate);
					
		}
		//ds
		public void deleteRv(int resSeq) throws FindException{
			ReservationDAO dao;
			dao = new ReservationDAOOracle();
			dao.deleteRv(resSeq);
		}
}
