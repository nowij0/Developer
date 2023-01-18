package com.developer.lessonreivew;

import java.util.List;

public interface LessonReivewDAO {
	
	/**
	 * [클래스] 수업에 해당하는 모든 후기 목록
	 * @author moonone
	 * @param lessonSeq 수업번호 
	 * @param filter 필터 선택값  
	 * @return 해당하는 모든 후기 목록
	 */
	public List<LessonReivewDAO> selectByfilter(int lessonSeq, int filter);
	
	
	/**
	 * [마이페이지] 튜티 : 수업에 해당하는 후기 작성 
	 * @author moonone
	 * @param lessonReviewVO 날짜, 후기, 별점
	 */
	public void addReview(LessonReivewVO lessonReviewVO);
	
	
	/**
	 * [마이페이지] 튜티 : 후기를 작성하지 않은 클래스 목록
	 * @param userId 회원아이디 
	 * @return 수업목록
	 */
	public List<LessonReivewVO> selectNotWrite(String userId);
	
	
	
	

}
