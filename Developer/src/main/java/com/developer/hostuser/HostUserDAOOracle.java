package com.developer.hostuser;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class HostUserDAOOracle implements HostUserDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	public HostUserDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//sr
	@Override
	public int deleteHostUser(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.delete("com.developer.hostuser.deleteHostUser",hostId);
		session.commit();
		session.close();
		return a;	
	}

	//sr
	@Override
	public HostUserVO getHostUser(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		HostUserVO vo = (HostUserVO)session.selectOne("com.developer.hostuser.getHostUser", hostId);
		session.close();
		return vo;
	}

	//sr
	@Override
	public int updateHostUser(HostUserVO hostUserVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.update("com.developer.hostuser.updateHostUser", hostUserVO);
		session.commit();
		session.close();
		return a;
		
	}

}
