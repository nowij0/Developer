package com.developer.hostuser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class HostUserDAOOracle implements HostUserDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public HostUserDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	

	@Override
	public List<HostUserVO> selectAll() throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	//근형 호스트회원 로그인
	@Override
	public HostUserVO hostLogin(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		HostUserVO vo = (HostUserVO) session.selectOne("com.developer.hostuser.hostLogin", hostId);
		session.close();
		return vo;
	}
	
	//근형 호스트회원 아이디찾기 
	@Override
	public HostUserVO selectHostId(String num) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		HostUserVO vo = (HostUserVO) session.selectOne("com.developer.hostuser.selectHostId", num);
		session.close();
		return vo;
	}

	//근형 호스트회원 비밀번호찾기
	@Override
	public HostUserVO selectHostPwd(String hostId, String num, String email) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("hostId", hostId);
		param.put("num", num);
		param.put("email", email);
		HostUserVO vo = (HostUserVO) session.selectOne("com.developer.hostuser.selectHostPwd", param);
		session.close();
		return vo;
	}
 
}
