<<<<<<< HEAD
=======
package com.developer.appliedlesson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;
import com.developer.userreview.UserReviewVO;

public class AppliedLessonDAOOracle implements AppliedLessonDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public AppliedLessonDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//장학
	@Override
	public List<AppliedLessonVO> getLessonApplyUsers0(int applyOk, int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyOk", applyOk);
		map.put("lessonSeq", lessonSeq);
		List<AppliedLessonVO> list = session.selectList("com.developer.appliedlesson.getLessonApplyUsers0", map);
		session.close();
		return list;
	}

	//장학
	@Override
	public List<AppliedLessonVO> getLessonApplyUsers1(int applyOk, int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyOk", applyOk);
		map.put("lessonSeq", lessonSeq);
		List<AppliedLessonVO> list = session.selectList("com.developer.appliedlesson.getLessonApplyUsers1", map);
//		session.close();
		return list;
	}

	
	//장학
	@Override
	public void updateApplyLesson(AppliedLessonVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("com.developer.appliedlesson.updateApplyLesson", vo);
		session.commit();
		session.close();
	}

	//장학
	@Override
	public void updateNotApplyLesson(AppliedLessonVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("com.developer.appliedlesson.updateNotApplyLesson", vo);
		session.commit();
		session.close();
	}

	public static void main(String[] args) throws FindException {
		System.out.println("시작");
		AppliedLessonDAOOracle dao = new AppliedLessonDAOOracle();
		AppliedLessonVO vo = new AppliedLessonVO();
		vo.setApplySeq(2);
		vo.setUserId("moonone470");
		dao.updateNotApplyLesson(vo);
//		List<AppliedLessonVO> list = dao.getLessonApplyUsers1(1, 4);
//		for(AppliedLessonVO v : list) {
//
//			System.out.println(v);
//		}
	}
	//지원 [미완]
	@Override
	public List<AppliedLessonVO> tuteeDashboard(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<AppliedLessonVO> tuteeDashboard = session.selectList("com.developer.appliedLesson.tuteeDashboard", userId);
		session.commit();
		session.close();
		return tuteeDashboard;
	}
	

}
>>>>>>> 24016e656d39b0bdcea57683fe473175c58dd951
