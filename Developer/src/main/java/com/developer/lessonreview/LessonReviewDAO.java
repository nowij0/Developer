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
	
	
	/**
	 * [클래스: 상세정보] 해당 튜터의 후기 개수
	 * @author moonone
	 * @param userId 튜터아이디 
	 * @return 후기개수 
	 * @throws FindException
	 */
	public int cntReviewTutor(String userId) throws FindException;
	
	
	/**
	 * [마이페이지 : 튜티] 튜터의 수업에 대한 후기 작성 
	 * @author moonone
	 * @param lessonReviewVO 튜터의 수업에 대한 후기  
	 * @throws FindException
	 */
	public void addReview(LessonReviewVO lessonReviewVO) throws FindException; 
	
	
	/**
	 * [마이페이지 : 튜티] 후기를 작성하지 않은 수업 목록 확인 
	 * @author moonone
	 * @param userId 유저아이디 
	 * @return 후기를 작성하지 않은 수업목록 
	 * @throws FindException
	 */
	public List<AppliedLessonVO> noWriteReview(String userId) throws FindException;
	
	/**
	 * [마이페이지 : 튜티] 작성한 후기 목록 확인 
	 * @author moonone
	 * @param userId 유저아이디 
	 * @return 후기목록 
	 * @throws FindException
	 */
	public List<AppliedLessonVO> myReviewList(String userId) throws FindException;

}
