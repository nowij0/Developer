package com.developer.appliedlesson.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class AppliedLessonDAOOracle implements AppliedLessonDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public AppliedLessonDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	//장학=>이거 applyOk를 0으로 고정시키면 되니까 굳이 파람 두개 넣을 필요는 없는거였음..
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
	public void updateApplyLesson(int applySeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("com.developer.appliedlesson.updateApplyLesson", applySeq);
		session.commit();
		session.close();
	}

	//장학
	@Override
	public void updateNotApplyLesson(int applySeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("com.developer.appliedlesson.updateNotApplyLesson", applySeq);
		session.commit();
		session.close();
	}
	
	//장학 
	@Override
	public AppliedLessonVO getAppliedLesson(int applySeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		AppliedLessonVO vo = (AppliedLessonVO) session.selectOne("com.developer.appliedlesson.getAppliedLesson", applySeq);
		return vo;
	}

	//지원 [미완]
	@Override
	public List<AppliedLessonVO> tuteeDashboard(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<AppliedLessonVO> tuteeDashboard = session.selectList("com.developer.appliedlesson.tuteeDashboard", userId);
		session.commit();
		session.close();
		return tuteeDashboard;
	}
	

}

