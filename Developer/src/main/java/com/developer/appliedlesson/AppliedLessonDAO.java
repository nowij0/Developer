package com.developer.appliedlesson;

import java.util.List;

import com.developer.exception.FindException;

public interface AppliedLessonDAO {

	/**
	 * [마이페이지: 튜티] 대시보드 
	 * @author moonone
	 * @param userId 회원아이디 
	 * @return 신청한 수업 상태 및 목록 확인 
	 * @throws FindException
	 */
	public List<AppliedLessonVO> tuteeDashboard (String userId) throws FindException;
}
