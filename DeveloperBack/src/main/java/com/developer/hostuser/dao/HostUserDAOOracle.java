package com.developer.hostuser.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.hostuser.vo.HostUserVO;
import com.developer.resource.Factory;

public class HostUserDAOOracle implements HostUserDAO {
	private SqlSessionFactory sqlSessionFactory;

	public HostUserDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	@Override
	public List<HostUserVO> selectAll() throws FindException {
		return null;
	}


	// 근형 호스트회원 로그인
	@Override
	public HostUserVO hostLogin(String hostId, String pwd) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, String> param = new HashMap<String, String>();
		param.put("hostId", hostId);
		param.put("pwd", pwd);
		HostUserVO vo = (HostUserVO) session.selectOne("com.developer.hostuser.hostLogin", param);
		session.close();
		return vo;
	}

	// 근형 호스트회원 아이디찾기
	@Override
	public HostUserVO selectHostId(String num) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		HostUserVO vo = (HostUserVO) session.selectOne("com.developer.hostuser.selectHostId", num);
		return vo;
	}
	
	// 근형 호스트회원 비밀번호찾기
	@Override
	public HostUserVO selectHostPwd(String hostId, String num, String email) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("hostId", hostId);
		param.put("num", num);
		param.put("email", email);
		HostUserVO vo = (HostUserVO) session.selectOne("com.developer.hostuser.selectHostPwd", param);
		session.close();
		return vo;
	}

	// sr
	@Override
	public int deleteHostUser(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.delete("com.developer.hostuser.deleteHostUser", hostId);
		session.commit();
		session.close();
		return a;
	}

	// sr
	@Override
	public HostUserVO getHostUser(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		HostUserVO vo = (HostUserVO) session.selectOne("com.developer.hostuser.getHostUser", hostId);
		session.close();
		return vo;
	}

	// sr
	@Override
	public int updateHostUser(HostUserVO hostUserVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.update("com.developer.hostuser.updateHostUser", hostUserVO);
		session.commit();
		session.close();
		return a;

	}

	//장학 
	public int joinHostUser(HostUserVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.hostuser.joinHostUser", vo);
		session.commit();// 커밋 필수....
		session.close();
		return a;
	}

}
