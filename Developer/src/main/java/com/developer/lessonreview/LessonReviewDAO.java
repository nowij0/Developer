package com.developer.lessonreview;

import java.util.List;

import com.developer.appliedlesson.AppliedLessonVO;
import com.developer.exception.FindException;

public interface LessonReviewDAO {	
	/**
	    * [일반회원 : 클래스 > 튜터 > 진행 완료된 클래스 > 상세 정보] 클래스 후기 목록
	    * @author choigeunhyeong
	    * @param 특정 lesson의 lessonSeq
	    * @return lessonSeq에 해당하는 LessonReview list
	    */
	public List<AppliedLessonVO> selectLessonReview(int lessonSeq) throws FindException;
	
	

}
