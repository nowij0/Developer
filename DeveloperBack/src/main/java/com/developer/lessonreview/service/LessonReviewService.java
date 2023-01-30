package com.developer.lessonreview.service;

import java.util.List;

import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.lessonreview.dao.LessonReviewDAOOracle;
import com.developer.lessonreview.vo.LessonReviewVO;

public class LessonReviewService {
	
	LessonReviewDAOOracle dao = new LessonReviewDAOOracle();
	
	//[JW] 해당 튜터의 후기 개수 
	public int cntReviewTutor(String userId) throws FindException {
		int cntReviewTutor = dao.cntReviewTutor(userId);
		return cntReviewTutor;
	}
	
	//[JW] 튜터의 수업에 대한 후기 작성 
	public void addReview(LessonReviewVO lessonReviewVO) throws FindException {
		dao.addReview(lessonReviewVO);
	}
	
	//[JW] 후기를 작성하지 않은 수업 목록 확인 
	public List<AppliedLessonVO> noWriteReview(String userId) throws FindException {
		List<AppliedLessonVO> noWriteReview = dao.noWriteReview(userId);
		return noWriteReview;
	}
	
	//[JW] 작성한 후기 목록 확인 
	public List<AppliedLessonVO> myReviewList(String userId) throws FindException {
		List<AppliedLessonVO> myReviewList = dao.myReviewList(userId);
		return myReviewList;
	}
	
	//GH
	public List<AppliedLessonVO> selectLessonReview(int lessonSeq) throws FindException{
		return dao.selectLessonReview(lessonSeq);
	}

}
