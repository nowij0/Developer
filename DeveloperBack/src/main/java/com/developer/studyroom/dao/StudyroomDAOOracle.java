package com.developer.studyroom.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;
import com.developer.studyroom.vo.StudyroomVO;

public class StudyroomDAOOracle implements StudyroomDAO {
	private SqlSessionFactory sqlSessionFactory;

	public StudyroomDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	public static void main(String[] args) throws FindException { //
		StudyroomDAOOracle dao = new StudyroomDAOOracle(); 
		 List<StudyroomVO> list = dao.selectAll(1);
		 System.out.println("-------");
		 
		 for(StudyroomVO vo: list) {
			 System.out.println(vo);
		 }
		 System.out.println("-------");
		}
	
	@Override//성공
	public List<StudyroomVO> selectBySearchString(String srNameAddrName, int searchBy, int person, int orderBy) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		
		String choose1 = "";
		if(searchBy == 1) {
			//vo.setName(srNameAddrName);
			choose1 = "S.ADDR LIKE '%" +srNameAddrName+ "%' ";
		}else if(searchBy == 2) {
			choose1 =  "S.NAME LIKE '%"+srNameAddrName+ "%' ";
		}
		
		String choose2 = "";
		if(orderBy==1) {
			choose2 = "PRICE ASC";
		}else if(orderBy == 2) {
			choose2 = "FAV_CNT DESC";
		}
		Map<String, Object> map = new HashMap<>();
		map.put("choose1", choose1);
		map.put("person", person);
		map.put("choose2", choose2);
		List<StudyroomVO> list = session.selectList("com.developer.studyroom.selectBySearchString1", map);
		
		//vo.setSearchBy(searchBy);
		//vo.setOrderBy(orderBy);
		
		//List<StudyroomVO> list = session.selectList("com.developer.studyroom.selectBySearchString",vo);//map);
		
		session.close();
		return list;
	}
	@Override //성공
	public List<StudyroomVO> selectAll(int orderBy) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderBy", orderBy);
		List<StudyroomVO> list = session.selectList("com.developer.studyroom.selectAll",map);
		session.close();
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
		session.commit();
		session.close();
		return list;
	}
	
	
	//성공
	@Override
	public StudyroomVO selectAllDetail(int srSeq) throws FindException{
		SqlSession session = sqlSessionFactory.openSession();
		StudyroomVO vo=(StudyroomVO)session.selectOne("com.developer.studyroom.selectAllDetail",srSeq);
		session.close();
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
