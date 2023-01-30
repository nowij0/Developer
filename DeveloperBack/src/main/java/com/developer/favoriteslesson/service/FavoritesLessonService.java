package com.developer.favoriteslesson.service;

import com.developer.exception.FindException;
import com.developer.favoriteslesson.dao.FavoritesLessonDAOOracle;
import com.developer.favoriteslesson.vo.FavoritesLessonVO;

public class FavoritesLessonService {
	
	FavoritesLessonDAOOracle dao = new FavoritesLessonDAOOracle();
	
	//수업 즐겨찾기 추가 
	public void addFavLesson(FavoritesLessonVO favoritesLessonVO) throws FindException{
		dao.addFavLesson(favoritesLessonVO);
	}
	
	//수업 즐겨찾기 삭제 
	public void delFavLesson(int favLesSeq) throws FindException{
		dao.delFavLesson(favLesSeq);
	}

}
