package com.developer.favoriteslesson.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.favoriteslesson.vo.FavoritesLessonVO;
import com.developer.resource.Factory;

public class FavoritesLessonDAOOracle implements FavoritesLessonDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public FavoritesLessonDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	//지원 
	@Override
	public void addFavLesson(FavoritesLessonVO favoritesLessonVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.selectOne("com.developer.favoriteslesson.addFavLesson", favoritesLessonVO);
		session.commit();
		session.close();
	}

	//지원 
	@Override
	public void delFavLesson(int favLesSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.selectOne("com.developer.favoriteslesson.delFavLesson", favLesSeq);
		session.commit();
		session.close();
	}

}
