package com.developer.studyroom;

import java.util.List;

import com.developer.exception.FindException;

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
}
