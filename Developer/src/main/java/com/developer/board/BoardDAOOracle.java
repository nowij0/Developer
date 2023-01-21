package com.developer.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class BoardDAOOracle implements BoardDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	public BoardDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	//sr
	@Override
	public List<BoardVO> boardSelectAllByDate() throws FindException {
			SqlSession session = sqlSessionFactory.openSession();
			List<BoardVO> list = session.selectList("com.developer.board.boardSelectAllByDate");
			session.close();
			return list;
			
	}

}
