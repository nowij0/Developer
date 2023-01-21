package com.developer.board.recommend;



import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import com.developer.exception.FindException;
import com.developer.resource.Factory;


public class RecommendDAOOracle implements RecommendDAO {
	
	private SqlSessionFactory sqlSessionFactory;

	public RecommendDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//근형
	@Override
	public void addRecommend(RecommendVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("com.developer.boardRecommend.addRecommend", vo);
		session.commit();
		session.close();
	}
	
	//근형
	@Override
	public void delRecommend(int recSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.developer.boardRecommend.delRecommend", recSeq);
		session.commit();
		session.close();
		
		
	}

}
