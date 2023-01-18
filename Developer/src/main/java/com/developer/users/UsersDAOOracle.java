package com.developer.users;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.appliedlesson.AppliedLessonVO;
import com.developer.exception.FindException;
import com.developer.hostuser.HostUserVO;
import com.developer.lesson.LessonVO;
import com.developer.resource.Factory;

public class UsersDAOOracle implements UsersDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UsersDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	

	@Override
	public List<UsersVO> selectAll() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> list = session.selectList("com.developer.users.selectAll");
		
		return list;
	}
		
//	public static void main(String[] args) throws FindException {
//		UsersDAOOracle dao = new UsersDAOOracle();
//		UsersVO vo = new UsersVO();
////		List<UsersVO> list = dao.selectAll();
//		vo = dao.getUsers("devman");
//		System.out.println("되어라.");
//		System.out.println(vo);
//		System.out.println("===");
//	}

	@Override
	public List<UsersVO> selectTutor() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> tList = session.selectList("com.developer.users.selectTutor");
		return tList;
	}
  
	@Override
	public UsersVO getUsers(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.getUsers", userId); // 이게 맞는지..
		return vo;
	}

	@Override
	public void joinUser(UsersVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("com.developer.users.joinUser",vo);
	}
	
//	public static void main(String[] args) throws FindException {
//		UsersDAOOracle dao = new UsersDAOOracle();
//		UsersVO vo = new UsersVO();
//		List<UsersVO> list = dao.selectAll();
//		vo = dao.joinUser("devman");
//		System.out.println("되어라.");
//		System.out.println(vo);
//		System.out.println("===");
//	}
	
	@Override
	public void joinHostUser(HostUserVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
	}
	
	@Override
	public void updateUsers(UsersVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
	}
	
	@Override
	public LessonVO getLesson(int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		
		return null;
		
	}
	
	@Override
	public void updateLesson(LessonVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
	}
	
	@Override
	public void deleteLesson(int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
	}
	
	@Override
	public List<UsersVO> getLessonApplyUsers(int applyOk, int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		
		return null;
	}
	
	@Override
	public void updateApplyLesson(AppliedLessonVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
	}
	
	@Override
	public void updateNotApplyLesson(AppliedLessonVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
	}
	
	@Override
	public UsersVO getTutee(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		return null;
	}
	
	@Override
	public List<UsersVO> getLessonApplyOkUsers(int applyOk, int lessonSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		return null;
	}
	  
  
  

}

	




