package com.developer.userreview.dao;

import java.util.List;

import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.userreview.vo.UserReviewVO;

public interface UserReviewDAO {
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 예정 클래스 > 상세 정보] 신청튜티 평가
	 * @author Jin
	 * @param 튜티의 userId
	 * @return 튜티의 UserReviewVO
	 * @throws FindException
	 */
	public List<AppliedLessonVO> getTuteeReview(String userId) throws FindException;
	
	
	/**
	 * [일반회원 : 클래스 > 튜터 > 진행 완료된 클래스 > 클래스 참여 튜티 목록]후기 작성
	 * @author Jin
	 * @param UserReview vo 값 입력
	 * @throws FindException
	 */
	public int addTuteeReview(UserReviewVO vo) throws FindException;

}
