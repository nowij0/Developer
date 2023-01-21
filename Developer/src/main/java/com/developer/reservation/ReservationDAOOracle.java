package com.developer.reservation;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;
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

	public static void main(String[] args) throws FindException, ParseException { //
		ReservationDAOOracle dao = new ReservationDAOOracle(); 
		dao.deleteRv(24);
		
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
