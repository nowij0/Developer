package com.developer.roomreview.service;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.reservation.vo.ReservationVO;
import com.developer.roomreview.dao.RoomReviewDAO;
import com.developer.roomreview.dao.RoomReviewDAOOracle;
import com.developer.roomreview.vo.RoomReviewVO;

public class RoomReviewService {
	
	//ds
	public List<RoomReviewVO> selectAll(int srSeq) throws FindException{
		RoomReviewDAO dao;
		dao = new RoomReviewDAOOracle();
		List<RoomReviewVO> list =dao.selectAll(srSeq);
		return list;
	}
	
	//ds
	public List<RoomReviewVO> selectMyRmRv(String userId) throws FindException{
		RoomReviewDAO dao;
		dao = new RoomReviewDAOOracle();
		List<RoomReviewVO> list = dao.selectMyRmRv(userId);
		return list;
	}
	
	public RoomReviewVO selectMyRmRvDetail(int resSeq) throws FindException{
		RoomReviewDAO dao;
		dao = new RoomReviewDAOOracle();
		RoomReviewVO vo = dao.selectMyRmRvDetail(resSeq);
		return vo;
	}
	public List<ReservationVO> selectMyReqRmRv(String userId) throws FindException{
		RoomReviewDAO dao;
		dao = new RoomReviewDAOOracle();
		List<ReservationVO> list = dao.selectMyReqRmRv(userId);
		return list;
	}
	
	public void insertRmRv(String content, int star, int resSeq) throws FindException{
		RoomReviewDAO dao;
		dao = new RoomReviewDAOOracle();
		dao.insertRmRv(content, star, resSeq);
	}
	
}
