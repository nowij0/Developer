package com.developer.users;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
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

	@Override
	public List<UsersVO> selectTutor() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> tList = session.selectList("com.developer.users.selectTutor");
		return tList;
	}

	@Override
	//로그인을 위한 아이디 검색
	public UsersVO getUsers(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		UsersVO vo= session.selectOne("com.developer.users.getUsers", userId);
		return vo;
	}
	
	@Override
	//일반 회원 아이디 찾기
	public List<UsersVO> selectUserId(String email) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> userId = session.selectList("com.developer.users.selectUserId", email);
		return userId;
	}
	
//	@Override
//	public List<UsersVO> selectUserPwd(String userId, String email) throws FindException {
//		SqlSession session = sqlSessionFactory.openSession();
//		List<UsersVO> userPwd = session.selectList("com.developer.users.selectUserPwd", userId, email);
//		return userPwd;
//	}

	@Override
	public UsersVO selectUserPwd(String userId, String email) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//테스트용 메인메서드
	public static void main(String[] args) throws FindException {
		UsersDAOOracle dao = new UsersDAOOracle();
		System.out.println("?");
		System.out.println(dao.getUsers("kosta111"));
		System.out.println("===");
	}

}






