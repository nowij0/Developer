package com.developer.recommend.service;

import com.developer.exception.FindException;
import com.developer.recommend.dao.RecommendDAO;
import com.developer.recommend.dao.RecommendDAOOracle;
import com.developer.recommend.vo.RecommendVO;

public class RecommendService {
	private RecommendDAO dao = new RecommendDAOOracle();
	
	public void addRecommend(RecommendVO vo) throws FindException{
		dao.addRecommend(vo);
	}
	
	public void delRecommend(int recSeq) throws FindException{
		dao.delRecommend(recSeq);
	}
}
