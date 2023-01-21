package com.developer.roominfo;

import org.apache.ibatis.session.SqlSessionFactory;


import com.developer.resource.Factory;



public class RoomInfoDAOOracle implements RoomInfoDAO {
	private SqlSessionFactory sqlSessionFactory;
	public RoomInfoDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
}
