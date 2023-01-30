package com.developer.recommend.dao;



import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.recommend.vo.RecommendVO;
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
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("postSeq", vo.getPostSeq());
		param.put("userId", vo.getUserId());	
		session.insert("com.developer.boardRecommend.addRecommend", param);
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
