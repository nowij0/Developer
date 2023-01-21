package com.developer.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.appliedlesson.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.hostuser.HostUserVO;
import com.developer.lesson.LessonVO;
import com.developer.lessonreview.LessonReviewVO;
import com.developer.resource.Factory;

public class UsersDAOOracle implements UsersDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UsersDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	
	
	//근형
	@Override
	public List<UsersVO> selectAll() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> list = session.selectList("com.developer.users.selectAll");
		
		return list;
	}
	
	//근형 일반회원 로그인
	@Override
	public UsersVO userLogin(String userId) throws FindException {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.userLogin", userId);
		session.close();
		return vo;
	}
	
	//근형 일반회원 아이디찾기
	@Override
	public UsersVO selectUserId(String email) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.selectUserId", email);
		session.close();
		return vo;
	}

	//근형 일반회원 비밀번호찾기
	@Override
	public UsersVO selectUserPwd(String userId, String email) throws FindException {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId",userId);
		map.put("email", email);
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.selectUserPwd", map);
		session.close();
		return vo;
	}

	
}

	




