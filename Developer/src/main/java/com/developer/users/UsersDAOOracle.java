package com.developer.users;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.hostuser.HostUserVO;
import com.developer.resource.Factory;

public class UsersDAOOracle implements UsersDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UsersDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	

	//장학
	@Override
	public List<UsersVO> selectAll() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> list = session.selectList("com.developer.users.selectAll");
		
		return list;
	}
		


	//장학
	@Override
	public List<UsersVO> selectTutor() throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UsersVO> list = session.selectList("com.developer.users.selectTutor");
		session.close();
		return list;
	}

	
	//장학
	@Override
	public UsersVO getUsers(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		UsersVO vo = (UsersVO) session.selectOne("com.developer.users.getUsers", userId);
		return vo;
	}

	//장학
	@Override
	public int joinUser(UsersVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.users.joinUser",vo);
		session.commit();//커밋 필수....
		session.close();
		return  a;
	}
	
	//장학
	@Override
	public void joinHostUser(HostUserVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
	}
	
	//장학
	@Override
	public int updateUsers(UsersVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.users.updateUsers",vo);
		session.commit();
		session.close();
		return a;
	}

	//장학
	@Override
	public void deleteUser(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.developer.users.deleteUser",userId);
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

}