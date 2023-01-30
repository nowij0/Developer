package com.developer.tutor.dao;

import com.developer.exception.FindException;
import com.developer.tutor.vo.TutorVO;


public interface TutorDAO {

	/**
	 * [튜터등록] 
	 * @author moonone
	 * @param tutorVO 튜터정보 
	 * @throws FindException
	 */
	public void addTutor(TutorVO tutorVO) throws FindException;
	
}
