package com.developer.roominfo;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.reservation.ReservationDAO;
import com.developer.reservation.ReservationDAOOracle;

public class RoomInfoService {
	public List<RoomInfoVO> selectAll(int srSeq) throws FindException{
		RoomInfoDAO dao;
		dao = new RoomInfoDAOOracle();
		List<RoomInfoVO> list= dao.selectAll(srSeq);
		return list;
	}
}
