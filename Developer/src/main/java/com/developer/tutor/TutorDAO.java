package com.developer.tutor;

import com.developer.exception.FindException;

public interface TutorDAO {
	
	/**
	 * [튜터등록] 
	 * @author moonone
	 * @param userId 회원아이디 
	 * @param info 이력
	 * @param imgPath 대표사진  
	 */
	public void addTutor(TutorVO tutorVO) throws FindException;
	
	
}
