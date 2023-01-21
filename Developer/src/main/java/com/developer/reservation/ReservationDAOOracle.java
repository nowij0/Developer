package com.developer.reservation;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;

public class ReservationDAOOracle implements ReservationDAO {
private SqlSessionFactory sqlSessionFactory;
	
	public ReservationDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	

	

}
