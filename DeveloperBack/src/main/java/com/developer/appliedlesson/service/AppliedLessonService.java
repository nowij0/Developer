package com.developer.appliedlesson.service;

import java.util.List;

import com.developer.appliedlesson.dao.AppliedLessonDAOOracle;
import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.exception.FindException;

public class AppliedLessonService {

	AppliedLessonDAOOracle dao = new AppliedLessonDAOOracle();
	
	//[JW] 튜티 : 대시보드 [미완]
	public List<AppliedLessonVO> tuteeDashboard(String userId) throws FindException {
		List<AppliedLessonVO> tuteeDashboard = dao.tuteeDashboard(userId);
		return tuteeDashboard;
	}
	
	public List<AppliedLessonVO> getLessonApplyUsers0(int applyOk, int lessonSeq) throws FindException{
		return dao.getLessonApplyUsers0(applyOk, lessonSeq);
	}
	
	public List<AppliedLessonVO> getLessonApplyUsers1(int applyOk, int lessonSeq) throws FindException{
		return dao.getLessonApplyUsers1(applyOk, lessonSeq);
	}
	
	public void updateApplyLesson(int applySeq) throws FindException{
		dao.updateApplyLesson(applySeq);
	}
	
	public void updateNotApplyLesson(int applySeq) throws FindException{
		dao.updateNotApplyLesson(applySeq);
	}
	
	public AppliedLessonVO getAppliedLesson(int applySeq) throws FindException{
		return dao.getAppliedLesson(applySeq);
		
	}
}
