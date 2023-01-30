package com.developer.tutor.service;

import com.developer.exception.FindException;
import com.developer.tutor.dao.TutorDAOOracle;
import com.developer.tutor.vo.TutorVO;

public class TutorService {
	
	TutorDAOOracle dao = new TutorDAOOracle();
	
	//튜터등록 
	public void addTutor(TutorVO tutorVO) throws FindException{
		dao.addTutor(tutorVO);
	}

}
