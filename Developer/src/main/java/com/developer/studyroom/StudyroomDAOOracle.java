package com.developer.studyroom;

import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.resource.Factory;

public class StudyroomDAOOracle implements StudyroomDAO {
	private SqlSessionFactory sqlSessionFactory;

	public StudyroomDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//sr
	@Override
	public int reservationOpen(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();

		int a = session.update("com.developer.studyroom.reservationOpen", hostId);
		session.commit();
		session.close();
		return a;

	}
	
	//sr
	@Override
	public int reservationClose(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.update("com.developer.studyroom.reservationClose", hostId);
		session.commit();
		session.close();
		return a;
	}

	//sr
	@Override
	public StudyroomVO getStudycafe(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		StudyroomVO vo = (StudyroomVO) session.selectOne("com.developer.studyroom.getStudycafe", hostId);
		session.close();
		return vo;
	}


	//sr
	@Override
	public void insertStudycafe(StudyroomVO studyroomVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("com.developer.studyroom.insertStudycafe", studyroomVO);
		session.commit();
		session.close();

	}


	//sr
	@Override
	public List<StudyroomVO> selectAllRoom(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudyroomVO> list = session.selectList("com.developer.studyroom.selectAllRoom", hostId);
		session.close();
		return list;
	}
	

	//sr
	@Override
	public StudyroomVO getHostAndStudyroom(String hostId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		StudyroomVO vo = (StudyroomVO) session.selectOne("com.developer.studyroom.getHostAndStudyroom", hostId);
		return vo;
	}

	//sr
	@Override
	public int updateStudycafe(StudyroomVO studyroomVO) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.update("com.developer.studyroom.updateStudycafe", studyroomVO);
		session.commit();
		session.close();
		return a;
	}
}
