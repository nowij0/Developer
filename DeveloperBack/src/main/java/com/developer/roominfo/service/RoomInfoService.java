package com.developer.roominfo.service;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.roominfo.dao.RoomInfoDAO;
import com.developer.roominfo.dao.RoomInfoDAOOracle;
import com.developer.roominfo.vo.RoomInfoVO;

public class RoomInfoService {
	//ds: 스터디룸의 전체정보를 출력
	public List<RoomInfoVO> selectAll(int srSeq) throws FindException{
		RoomInfoDAO dao;
		dao = new RoomInfoDAOOracle();
		List<RoomInfoVO> list= dao.selectAll(srSeq);
		return list;
	}
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
