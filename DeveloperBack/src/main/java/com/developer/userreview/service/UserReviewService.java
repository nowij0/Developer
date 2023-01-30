package com.developer.userreview.service;

import java.util.List;

import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.userreview.dao.UserReviewDAO;
import com.developer.userreview.dao.UserReviewDAOOracle;
import com.developer.userreview.vo.UserReviewVO;

public class UserReviewService {

	UserReviewDAO dao = new UserReviewDAOOracle();
	
	public List<AppliedLessonVO> getTuteeReview(String userId) throws FindException{
		return dao.getTuteeReview(userId);
	}
	
	public int addTuteeReview(UserReviewVO vo) throws FindException{
		return dao.addTuteeReview(vo);
	}
	
}
