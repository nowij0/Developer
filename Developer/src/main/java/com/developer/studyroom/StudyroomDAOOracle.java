package com.developer.studyroom;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;


public class StudyroomDAOOracle implements StudyroomDAO {
	private SqlSessionFactory sqlSessionFactory;
	public StudyroomDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	@Override
	public List<StudyroomVO> selectBySerch1(String search1) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<StudyroomVO> list = session.selectList("com.developer.studyroom.selectBySerch1");
		
		return list;
	}
	@Override
	public List<StudyroomVO> selectByPerson(int person) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<StudyroomVO> plist = session.selectList("com.developer.studyroom.selectByPerson");
		
		return plist;
	}
	
	@Override
	public List<StudyroomVO> selectByAddrAndPerson(String addr, int person) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<StudyroomVO> aplist = session.selectList("com.developer.studyroom.selectByAddrAndPerson");
		
		return aplist;
	}
	@Override
	public List<StudyroomVO> selectAll(int srSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<StudyroomVO> listall = session.selectList("com.developer.studyroom.selectAll");
		
		return listall;
	}
	
}
