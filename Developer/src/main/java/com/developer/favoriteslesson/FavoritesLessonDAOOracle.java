package com.developer.favoriteslesson;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class FavoritesLessonDAOOracle implements FavoritesLessonDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public FavoritesLessonDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public static void main(String[] args) throws FindException {
		FavoritesLessonDAOOracle dao = new FavoritesLessonDAOOracle();
		dao.delFavLesson("moonone470", 3);
		System.out.println("완료");
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
	public void delFavLesson(String userId, int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("lessonSeq", lessonSeq);
		session.selectOne("com.developer.favoriteslesson.delFavLesson", map);
		session.commit();
		session.close();
	}

}
