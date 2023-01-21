package com.developer.lessonreview;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.appliedlesson.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class LessonReviewDAOOracle implements LessonReviewDAO {
	private SqlSessionFactory sqlSessionFactory;

	public LessonReviewDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	//근형
	@Override
	public List<AppliedLessonVO> selectLessonReview(int lessonSeq) throws FindException {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<AppliedLessonVO> list = session.selectList("com.developer.lessonReview.selectLessonReview", lessonSeq);
		session.close();
		return list;
	}

}
