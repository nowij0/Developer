package com.developer.tutor;

public interface TutorDAO {
	
	/**
	 * [튜터등록]
	 * @author moonone
	 * @param userId 회원아이디 
	 * @param info 이력
	 * @param imgPath 대표사진  
	 */
	public void addTutor(String userId, String info, String imgPath);
	
	/**
	 * [클래스] 튜터 정보 출력 
	 * @param userId 튜터의 아이디 
	 * @return 튜터에 대한 정보 
	 */
	public TutorVO selectTutor(String userId);
	
	
	
	
	
	
}
