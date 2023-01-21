package com.developer.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class UsersDAOOracle implements UsersDAO {

	private SqlSessionFactory sqlSessionFactory;

	public UsersDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	// 장학
	@Override
	public List<UsersVO> selectAll() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> list = session.selectList("com.developer.users.selectAll");

		return list;
	}

	// 장학
	@Override
	public List<UsersVO> selectTutor() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> list = session.selectList("com.developer.users.selectTutor");
		session.close();
		return list;
	}

	// 장학
	@Override
	public UsersVO getUsers(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.getUsers", userId);
		return vo;
	}

	// 장학
	@Override
	public int joinUser(UsersVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.users.joinUser", vo);
		session.commit();// 커밋 필수....
		session.close();
		return a;
	}


	// 장학
	@Override
	public int updateUsers(UsersVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.users.updateUsers", vo);
		session.commit();
		session.close();
		return a;
	}

	// 장학
	@Override
	public void deleteUser(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.developer.users.deleteUser", userId);
		session.commit();
		session.close();
	}

	public static void main(String[] args) throws FindException {
		UsersDAOOracle dao = new UsersDAOOracle();
		UsersVO vo = new UsersVO();
//		List<UsersVO> list = dao.selectAll();
		vo = dao.getUsers("aaa");
		System.out.println("되어라.");
		System.out.println(vo);
		System.out.println("===");
	}

	// 근형 일반회원 로그인
	@Override
	public UsersVO userLogin(String userId) throws FindException {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.userLogin", userId);
		session.close();
		return vo;
	}

	// 근형 일반회원 아이디찾기
	@Override
	public UsersVO selectUserId(String email) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.selectUserId", email);
		session.close();
		return vo;
	}

	// 근형 일반회원 비밀번호찾기
	@Override
	public UsersVO selectUserPwd(String userId, String email) throws FindException {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("email", email);
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.selectUserPwd", map);
		session.close();
		return vo;
	}

}