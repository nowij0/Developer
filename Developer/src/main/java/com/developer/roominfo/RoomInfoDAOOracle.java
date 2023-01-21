package com.developer.roominfo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import org.apache.ibatis.session.SqlSessionFactory;
import com.developer.resource.Factory;

public class RoomInfoDAOOracle implements RoomInfoDAO {
	private SqlSessionFactory sqlSessionFactory;

	public RoomInfoDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}


	//sr
	@Override
	public void insertRoom(RoomInfoVO roomInfoVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("com.developer.roominfo.insertRoom", roomInfoVO);
		session.commit();
		session.close();
	}

	//sr
	@Override
	public int updateRoom(RoomInfoVO roomInfoVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.update("com.developer.roominfo.updateRoom", roomInfoVO);
		session.commit();
		session.close();
		return a;

	}

	//sr
	@Override
	public int deleteRoom(int roomSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.delete("com.developer.roominfo.deleteRoom", roomSeq);
		session.commit();
		session.close();
		return a;
	}


	//sr
	@Override
	public RoomInfoVO getRoom(int roomSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		RoomInfoVO vo = (RoomInfoVO) session.selectOne("com.developer.roominfo.getRoom", roomSeq);
		session.close();
		return vo;
	}


}
