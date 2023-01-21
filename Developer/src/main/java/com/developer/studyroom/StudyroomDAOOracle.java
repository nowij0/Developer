package com.developer.studyroom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class StudyroomDAOOracle implements StudyroomDAO {
	private SqlSessionFactory sqlSessionFactory;

	public StudyroomDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	public static void main(String[] args) throws FindException { //
		StudyroomDAOOracle dao = new StudyroomDAOOracle(); 
		 List<StudyroomVO> list = dao.selectBySearchString("장학", 2, 2);
		 System.out.println("-------");
		 System.out.println(list);
		 System.out.println("-------");
		}
	
	@Override
	public List<StudyroomVO> selectBySearchString(String srNameAddrName, int searchBy, int orderBy) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("srNameAddrName", srNameAddrName);
		map.put("searchBy", searchBy);
		map.put("orderBy", orderBy);
		
		List<StudyroomVO> list = session.selectList("com.developer.studyroom.selectBySearchString",map);
		
		return list;
	}
	@Override //성공
	public List<StudyroomVO> selectByPerson(int person, int orderBy) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("person", person);
		map.put("orderBy", orderBy);
		
		List<StudyroomVO> list = session.selectList("com.developer.studyroom.selectByPerson",map);
		return list;
	}
	
	@Override //성공
	public List<StudyroomVO> selectByAddrAndPerson(String addr, int person, int orderBy) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("addr",addr);
		map.put("person", person);
		map.put("orderBy", orderBy);
		List<StudyroomVO> list = session.selectList("com.developer.studyroom.selectByAddrAndPerson", map);
		
		return list;
	}
	
	
	//성공
	@Override
	public StudyroomVO selectAllDetail(int srSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StudyroomVO vo=(StudyroomVO)session.selectOne("com.developer.studyroom.selectAllDetail",srSeq);
		
		return vo;
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
