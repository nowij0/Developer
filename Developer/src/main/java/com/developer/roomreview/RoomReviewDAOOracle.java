package com.developer.roomreview;

import java.text.ParseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;

public class RoomReviewDAOOracle implements RoomReviewDAO {

	private SqlSessionFactory sqlSessionFactory;
	public RoomReviewDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	
//	public static void main(String[] args) throws FindException, ParseException { //
//		RoomReviewDAOOracle dao = new RoomReviewDAOOracle(); 
//		dao.insertRmRv("저렴하고 좋아욤", 3, 23);
//			
//	}
	
	public static void main(String[] args) throws FindException, ParseException { //
		RoomReviewDAOOracle dao = new RoomReviewDAOOracle(); 
//		 RoomReviewVO vo=dao.selectMyRmRvDetail(23);
//		 List<RoomReviewVO> list=dao.selectMyRmRv("moonone470");
		 List<RoomReviewVO> list2= dao.selectMyReqRmRv("moonone470");
		 System.out.println("-------");
//			 System.out.println("selectMyRmRv:"+list);
//		 System.out.println("-------");
//		 System.out.println("selectMyRmRvDetail: "+vo);
//		 System.out.println("-------");
		 System.out.println("selectMyReqRmRv: "+list2);
	}
	//성공
	@Override
	public List<RoomReviewVO> selectAll(int srSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<RoomReviewVO> list = session.selectList("com.developer.roomreview.selectAll",srSeq);
		session.close();
		return list;
	}
	//성공
	@Override
	public List<RoomReviewVO> selectMyRmRv(String userId) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<RoomReviewVO> list = session.selectList("com.developer.roomreview.selectMyRmRv",userId);
		session.close();
		return list;
	}
	//성공
	@Override
	public RoomReviewVO selectMyRmRvDetail(int resSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		RoomReviewVO vo = session.selectOne("com.developer.roomreview.selectMyRmRvDetail",resSeq);
		session.close();
		return vo;
	}//성공	
	@Override
	public List<RoomReviewVO> selectMyReqRmRv(String userId) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		List<RoomReviewVO> list = session.selectList("com.developer.roomreview.selectMyReqRmRv",userId);
		session.close();
		return list;
	}
	//성공
	@Override
	public void insertRmRv(String content, int star, int resSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("content", content);
		map.put("star", star);
		map.put("resSeq", resSeq);
		
		session.selectList("com.developer.roomreview.insertRmRv",map);
		session.commit();
		session.close();
	}
}
