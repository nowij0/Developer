package com.developer.reservation;

<<<<<<< HEAD

public class ReservationDAOOracle implements ReservationDAO {
	
=======
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
	
	//sr
	@Override
	public ReservationVO selectReservation(int resSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ReservationVO vo = session.selectOne("com.developer.reservation.selectReservation", 2);
		session.close();
		return vo;

	}


	//sr
	@Override
	public int reservationDelete(int resSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.delete("com.developer.reservation.reservationDelete", resSeq);
		session.commit();
		session.close();
		return a;
		
	}
	
	//sr
	@Override
	public List<ReservationVO> selectAllStudycafeReservation(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<ReservationVO> list = session.selectList("com.developer.reservation.selectAllStudycafeReservation", hostId);
		session.close();
		return list;
	}
>>>>>>> 24016e656d39b0bdcea57683fe473175c58dd951

}
