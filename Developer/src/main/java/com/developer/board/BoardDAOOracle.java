package com.developer.board;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class BoardDAOOracle implements BoardDAO {

	private SqlSessionFactory sqlSessionFactory;

	public BoardDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	//근형
	@Override
	public List<BoardVO> selectBoardByType(int boardType) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("com.developer.board.selectAllBoard", boardType);
		session.close();
		return list;
	}
	
	//근형
	@Override
	public List<BoardVO> selectAllCnt(int postSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("com.developer.board.selectAllCnt", postSeq);
		session.close();
		return list;
	}
	
	//근형
	@Override
	public List<BoardVO> boardSearch(String title) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("com.developer.board.boardSearch", title);
		session.close();
		return list;
	}
	
	//근형
	@Override
	public List<BoardVO> selectByFilter(Date cDate, int cnt) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//근형
	@Override
	public List<BoardVO> selectByPostSeq(int postSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("com.developer.board.selectByPostSeq", postSeq);
		session.close();
		return list;
	}
	
	//근형
	@Override
	public void addBoard(BoardVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("postSeq", vo.getPostSeq());
		param.put("userId",vo.getUserId());
		param.put("category",vo.getCategory());
		param.put("title",vo.getTitle());
		param.put("content",vo.getContent());
		param.put("imgPath",vo.getImgPath());
		session.insert("com.developer.board.addBoard", param);
		session.commit();
		session.close();
	}
	
	//근형
	@Override
	public void editBoard(BoardVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("category", vo.getCategory());
		param.put("title", vo.getTitle());
		param.put("content", vo.getContent());
		param.put("imgPath", vo.getImgPath());
		param.put("postSeq", vo.getPostSeq());
		session.update("com.developer.board.editBoard", param);
		session.commit();
		session.close();
	}
	
	//근형
	@Override
	public void delBoard(int postSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.developer.board.delBoard",postSeq);
		session.commit();
		session.close();
	}
	
	//근형
//	@Override
//	public BoardVO checkRecommend(int postSeq) throws FindException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	//근형
	@Override
	public void updateCnt(int postSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("com.developer.board.updateCnt", postSeq);
		session.commit();
		session.close();
	
	}
	
	//근형
	@Override
	public BoardVO selectBoardDetail(int postSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVO vo = session.selectOne("com.developer.board.boardDetail", postSeq);
		session.commit();
		session.close();
		return vo;
	}

	// sr
	@Override
	public List<BoardVO> boardSelectAllByDate() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("com.developer.board.boardSelectAllByDate");
		session.close();
		return list;

	}


}
