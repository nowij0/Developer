package com.developer.users.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;
import com.developer.users.vo.UsersVO;

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
	public int updateUsers(UsersVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.users.updateUsers", vo);
		session.commit();
		session.close();
		return a;
	}

	// 장학
	@Override
	public int joinUsers(UsersVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.users.joinUser", vo);
		session.commit();
		session.close();
		return a;
	}

	// 장학
	@Override
	public void deleteUsers(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.developer.users.deleteUser", userId);
		session.commit();
		session.close();
	}

	// 근형 일반회원 로그인
	@Override
	public UsersVO userLogin(String userId, String pwd) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, String> param = new HashMap<String, String>();
		param.put("userId", userId);
		param.put("pwd", pwd);
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.userLogin", param);
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
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("email", email);
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.selectUserPwd", map);
		session.close();
		return vo;
	}

}