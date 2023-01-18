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
	
	@Override
	public List<RoomInfoVO> selectAll(int srSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<RoomInfoVO> list = session.selectList("com.developer.roominfo.selectAll");
		
		return list;
	}
	
	public static void main(String[] args) throws FindException {
		RoomInfoDAOOracle dao = new RoomInfoDAOOracle();
		System.out.println("?");
		System.out.println(dao.selectAll(1));
		System.out.println("===");
	}
	
}
