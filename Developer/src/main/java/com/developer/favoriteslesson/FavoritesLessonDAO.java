package com.developer.favoriteslesson;

import com.developer.exception.FindException;

public interface FavoritesLessonDAO {
	
	/**
	 * [클래스: 상세정보] 즐겨찾기 추가 
	 * @author moonone
	 * @param favoritesLessonVO 회원아이디, 수업번호
	 * @throws FindException
	 */
	public void addFavLesson(FavoritesLessonVO favoritesLessonVO) throws FindException;
	
	/**
	 * [클래스: 상세정보] 즐겨찾기 삭제
	 * @author moonone 
	 * @param userId 회원아이디 
	 * @param lessonseq 수업번호 
	 * @throws FindException
	 */
	public void delFavLesson(String userId, int lessonSeq) throws FindException;

}
