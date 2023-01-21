package com.developer.roominfo;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;



public class RoomInfoDAOOracle implements RoomInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	public RoomInfoDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	public static void main(String[] args) throws FindException { //
		RoomInfoDAOOracle dao = new RoomInfoDAOOracle(); 
		System.out.println("시작"); 
		List<RoomInfoVO> list = dao.selectAll(1);
		 for(RoomInfoVO vo: list) {
		 System.out.println(vo );
		 }
		 System.out.println("끝");
		}
	
	
	@Override  //성공
	public List<RoomInfoVO> selectAll(int srSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<RoomInfoVO> list = session.selectList("com.developer.roominfo.selectAll",srSeq);
		session.close();
		return list;
		
	}
	

}
