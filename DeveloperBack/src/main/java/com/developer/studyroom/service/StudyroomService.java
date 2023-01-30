package com.developer.studyroom.service;

import java.util.List;

import com.developer.exception.FindException;
import com.developer.studyroom.dao.StudyroomDAO;
import com.developer.studyroom.dao.StudyroomDAOOracle;
import com.developer.studyroom.vo.StudyroomVO;


public class StudyroomService {
	
	//ds
	public List<StudyroomVO> searchByAddrAndName(String srNameAddrName, int searchBy, int orderBy) throws FindException{
		StudyroomDAO dao;
		dao = new StudyroomDAOOracle();
		List<StudyroomVO> list = dao.selectBySearchString(srNameAddrName, searchBy, orderBy);
		return list;
		
	}
	//ds
	public List<StudyroomVO> searchByPerson(int person, int orderBy) throws FindException{
		StudyroomDAO dao;
		dao = new StudyroomDAOOracle();
		List<StudyroomVO> list = dao.selectByPerson(person, orderBy);
		return list;
	}
	//ds
	public List<StudyroomVO> searchByAddrAndPerson(String addr, int person, int orderBy) throws FindException{
		StudyroomDAO dao;
		dao = new StudyroomDAOOracle();
		List<StudyroomVO> list = dao.selectByAddrAndPerson(addr, person, orderBy);
		return list;
	}
	//ds
	public StudyroomVO printAllDetail(int srSeq) throws FindException{
		StudyroomDAO dao;
		dao = new StudyroomDAOOracle();
		StudyroomVO vo = dao.selectAllDetail(srSeq);
		return vo;
	}

	// sr: 호스트 마이페이지(호스트회원정보+카페정보 한번에)
	public StudyroomVO infoHostAndCafe(String hostId) throws FindException {
		StudyroomDAO dao = new StudyroomDAOOracle();
		return dao.getHostAndStudyroom(hostId);
	}

	// sr: 호스트 마이페이지(카페정보출력)
	public StudyroomVO infoCafe(String hostId) throws FindException {
		StudyroomDAO dao = new StudyroomDAOOracle();
		return dao.getStudycafe(hostId);
	}

	// sr: 호스트 마이페이지(룸정보 목록 출력)
	public List<StudyroomVO> listRoom(String hostId) throws FindException {
		StudyroomDAO dao = new StudyroomDAOOracle();
		return dao.selectAllRoom(hostId);
	}

	// sr: 호스트 회원가입(카페등록)
	public void addCafe(StudyroomVO studyroomVO) throws FindException {
		StudyroomDAO dao = new StudyroomDAOOracle();
		dao.insertStudycafe(studyroomVO);
	}

	// sr: 마이페이지(호스트 카페 오픈버튼)
	public int openCafe(String hostId) throws FindException {
		StudyroomDAO dao = new StudyroomDAOOracle();
		int a = dao.reservationOpen(hostId);
		return a;
	}

	// sr: 마이페이지(호스트 카페 마감버튼)
	public int closeCafe(String hostId) throws FindException {
		StudyroomDAO dao = new StudyroomDAOOracle();
		int a = dao.reservationClose(hostId);
		return a;
	}

	// sr: 마이페이지(호스트 카페정보수정)
	public int editCafe(StudyroomVO studyroomVO) throws FindException {
		StudyroomDAO dao = new StudyroomDAOOracle();
		int a = dao.updateStudycafe(studyroomVO);
		return a;
	}
}
