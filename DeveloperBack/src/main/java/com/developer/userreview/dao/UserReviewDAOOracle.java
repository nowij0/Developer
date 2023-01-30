package com.developer.userreview.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.resource.Factory;
import com.developer.userreview.vo.UserReviewVO;

public class UserReviewDAOOracle implements UserReviewDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserReviewDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//장학
	@Override
    public List<AppliedLessonVO> getTuteeReview(String userId) throws FindException {
    SqlSession session = sqlSessionFactory.openSession();
    List<AppliedLessonVO> list = session.selectList("com.developer.userreview.getTuteeReview", userId);

    return list;
	}	
	
	//장학
	@Override
	public int addTuteeReview(UserReviewVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.userreview.addTuteeReview",vo);
		session.commit();//커밋 필수....
		session.close();
		return  a;
	}	
	
}
