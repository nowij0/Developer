package com.developer.reservation;

import java.util.Date;
import java.util.List;

import com.developer.exception.FindException;

public class ReservationService {
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
