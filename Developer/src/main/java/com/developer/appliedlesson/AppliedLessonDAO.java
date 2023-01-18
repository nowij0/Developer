package com.developer.appliedlesson;

public interface AppliedLessonDAO {
	
	/**
	 * [클래스] 튜터의 모든 후기 개수 카운트 
	 * @author moonone
	 * @param applySeq 수업신청번호 
	 * @return 후기의 개수 
	 */
	public int cntReview(int applySeq);

}
