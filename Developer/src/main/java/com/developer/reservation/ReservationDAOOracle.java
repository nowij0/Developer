package com.developer.reservation;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class ReservationDAOOracle implements ReservationDAO {
	private SqlSessionFactory sqlSessionFactory;

	public ReservationDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//ds
	@Override // 성공
	public List<ReservationVO> selectAllByUsingDate(int roomSeq, Date usingDate) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roomSeq", roomSeq);
		map.put("usingDate", usingDate);

		List<ReservationVO> list = session.selectList("com.developer.reservation.selectAllByUsingDate", map);
		return list;
	}

	//ds
	@Override // 성공
	public void insertRv(String userId, int roomSeq, String startTime, String endTime, Date usingDate)
			throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("roomSeq", roomSeq);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("usingDate", usingDate);

		session.selectList("com.developer.reservation.insertRv", map);
		session.commit();
		session.close();
		// commit하고 close해줘야됨
	}

	//ds
	@Override // 성공
	public void deleteRv(int resSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();

		session.selectOne("com.developer.reservation.deleteRv", resSeq);
		session.commit();
		session.close();
		// commit하고 close해줘야됨

	}

	//ds
	@Override //성공
    public List<ReservationVO>  selectMyResHistory(String userId) throws FindException{
       SqlSession session = sqlSessionFactory.openSession();
       
       List<ReservationVO> list = session.selectList("com.developer.reservation.selectMyResHistory", userId);
       session.close();
       return list;
    }
	
	// sr
	@Override
	public ReservationVO selectReservation(int resSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		ReservationVO vo = session.selectOne("com.developer.reservation.selectReservation", 2);
		session.close();
		return vo;

	}

	// sr
	@Override
	public int reservationDelete(int resSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.delete("com.developer.reservation.reservationDelete", resSeq);
		session.commit();
		session.close();
		return a;

	}

	// sr
	@Override
	public List<ReservationVO> selectAllStudycafeReservation(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<ReservationVO> list = session.selectList("com.developer.reservation.selectAllStudycafeReservation",
				hostId);
		session.close();
		return list;
	}

}
