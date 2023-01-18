package com.developer.favoriteslesson;

public interface FavoritesLessonDAO {
	
	/**
	 * [클래스] 해당 수업 즐겨찾기 추가 
	 * @author moonone
	 * @param userId 로그인한 회원의 아이디 
	 * @param lessonSeq 수업번호 
	 */
	public void addFav(String userId, int lessonSeq);
	
	/**
	 * [클래스] 해당 수업 즐겨찾기 삭제
	 * @author moonone 
	 * @param userId 로그인한 회원의 아이디 
	 * @param lessonSeq 수업번호 
	 */
	public void delFav(String userId, int lessonSeq);

}
