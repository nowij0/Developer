package com.developer.hostuser;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;
import com.developer.users.UsersDAOOracle;
import com.developer.users.UsersVO;

public class HostUserDAOOracle implements HostUserDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	public HostUserDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//장학
	@Override
	public int joinHostUser(HostUserVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.hostuser.joinHostUser",vo);
		session.commit();//커밋 필수....
		session.close();
		return  a;
	}
	
	public static void main(String[] args) throws FindException {
		HostUserDAOOracle dao = new HostUserDAOOracle();
		HostUserVO vo = new HostUserVO();
		vo.setEmail("123");
		vo.setHostId("323");
		vo.setName("2324");
		vo.setNum("23423424");
		vo.setPwd("2323");
		vo.setTel("2344");
		dao.joinHostUser(vo);
		System.out.println(vo);
		
		
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
