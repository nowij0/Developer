package com.developer.roominfo;

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
