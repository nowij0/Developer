package com.developer.reservation;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;
import com.developer.studyroom.StudyroomVO;

public class ReservationDAOOracle implements ReservationDAO {
private SqlSessionFactory sqlSessionFactory;
	
	public ReservationDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	public static void main(String[] args) throws FindException, ParseException { //
		ReservationDAOOracle dao = new ReservationDAOOracle(); 
		
//		String str = "23-01-07";
//        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        java.sql.Date usingDate = java.sql.Date.valueOf("2023-01-07");
        
//        Date date = format.parse(str);
		
		List<ReservationVO> list = dao.selectAllByUsingDate(1, usingDate);
		System.out.println(list);
		System.out.println("시작"); 
			for(ReservationVO vo: list) {
				System.out.println(vo );
			}
			System.out.println("끝");	
			
	}
	@Override //성공
	public List<ReservationVO> selectAllByUsingDate(int roomSeq, Date usingDate) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roomSeq", roomSeq);
		map.put("usingDate", usingDate);
		
		
		List<ReservationVO> list = session.selectList("com.developer.reservation.selectAllByUsingDate",map);
		session.close();
		return list;
		
	}
		
		@Override //성공
		public List<ReservationVO>  selectMyResHistory(String userId) throws FindException{
			SqlSession session = sqlSessionFactory.openSession();
			List<ReservationVO> list = session.selectList("com.developer.reservation.selectMyResHistory", userId);
			session.close();
			return list;
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
	
	@Override //성공
	public void insertRv(String userId, int roomSeq, String startTime, String endTime, Date usingDate) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId",userId );
		map.put("roomSeq",roomSeq );
		map.put("startTime",startTime );
		map.put("endTime",endTime );
		map.put("usingDate",usingDate );
		
		session.selectList("com.developer.reservation.insertRv",map);
		session.commit();
		session.close();
		//commit하고 close해줘야됨
	}
	
		@Override	//성공	
		public void deleteRv(int resSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
			
		session.selectOne("com.developer.reservation.deleteRv", resSeq);
		session.commit();
		session.close();
			//commit하고 close해줘야됨

		
		}

		@Override
		public List<ReservationVO> studycafeReservationCheck(String hostId) throws FindException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<ReservationVO> studyroomReservationCheck(int roomSeq) throws FindException {
			// TODO Auto-generated method stub
			return null;
		}

	
		
//		public static void main(String[] args) throws FindException, ParseException { //
//		ReservationDAOOracle dao = new ReservationDAOOracle(); 
//		System.out.println("시작"); 
//		
//		String str = "23-01-07";
//        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
//        Date date = format.parse(str);
//		
//		List<ReservationVO> list = dao.selectAllByUsingDate(1, date);
//			for(ReservationVO vo: list) {
//				System.out.println(vo );
//			}
//			System.out.println("끝");		
//	
//	}
	

}
