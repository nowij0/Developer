package com.developer.reservation;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class ReservationDAOOracle implements ReservationDAO {
private SqlSessionFactory sqlSessionFactory;
	
	public ReservationDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	@Override
	public List<ReservationVO> selectAllByUsingDate(int roomSeq, Date usingDate) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<ReservationVO> list = session.selectList("com.developer.reservation.selectAllByUsingDate");
		return list;
		
	}
	
	@Override
	public void insertRv() throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		session.selectList("com.developer.reservation.insertRv");
		
		
	}
	
	

}
