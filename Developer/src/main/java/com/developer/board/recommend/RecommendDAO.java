package com.developer.board.recommend;

import com.developer.exception.FindException;

public interface RecommendDAO {
	/**
	 * [커뮤니티 > 글 상세페이지] 추천수 증가
	 * @author choigeunhyeong
	 * @param RecommendVO 객체
	 * @throws FindException
	 */
	public void addRecommend(RecommendVO vo) throws FindException;
	
	/**
	 * [커뮤니티 >  글 상세페이지] 추천수 감소
	 * @author choigeunhyeong
	 * @param recSeq
	 * @throws FindException
	 */
	public void delRecommend(int recSeq) throws FindException;
	
	
}
