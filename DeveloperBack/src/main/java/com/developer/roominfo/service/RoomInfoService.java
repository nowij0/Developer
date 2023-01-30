package com.developer.roominfo.service;

import com.developer.exception.FindException;
import com.developer.roominfo.dao.RoomInfoDAO;
import com.developer.roominfo.dao.RoomInfoDAOOracle;
import com.developer.roominfo.vo.RoomInfoVO;

public class RoomInfoService {

	// sr: 호스트 마이페이지(방정보)
	public RoomInfoVO infoRoom(int roomSeq) throws FindException {
		RoomInfoDAO dao = new RoomInfoDAOOracle();
		return dao.getRoom(roomSeq);
	}

	// sr: 호스트 마이페이지(방등록)
	public void addRoom(RoomInfoVO roomInfoVO) throws FindException {
		RoomInfoDAO dao = new RoomInfoDAOOracle();
		dao.insertRoom(roomInfoVO);
	}

	// sr: 호스트 마이페이지(방삭제)
	public int delRoom(int roomSeq) throws FindException {
		RoomInfoDAO dao = new RoomInfoDAOOracle();
		int a = dao.deleteRoom(roomSeq);
		return a;
	}
	
	
	// sr: 호스트 마이페이지(방수정)
		public int editRoom(RoomInfoVO roomInfoVO) throws FindException {
			RoomInfoDAO dao = new RoomInfoDAOOracle();
			int a = dao.updateRoom(roomInfoVO);
			return a;
		}
}
