package com.developer.recommend;

import com.developer.exception.FindException;

public interface RecommendDAO {
	/**
	 * <커뮤니티 : 글 상세페이지> 글에 대한 추천수 증가
	 * @author choigeunhyeong
	 * @param vo
	 * @throws FindException
	 */
	public void addRecommend(RecommendVO vo) throws FindException;
	
	/**
	 * <커뮤니티 :글 상세페이지> 글에 대한 추천 감소
	 * @author choigeunhyeong
	 * @param recSeq 삭제될 추천번호
	 * @throws FindException
	 */
	public void delRecommend(int recSeq) throws FindException;
}
