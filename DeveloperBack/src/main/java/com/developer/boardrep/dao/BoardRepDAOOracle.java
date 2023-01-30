package com.developer.boardrep.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.boardrep.vo.BoardRepVO;
import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class BoardRepDAOOracle implements BoardRepDAO {
	
	private SqlSessionFactory sqlSessionFactory;

	public BoardRepDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}	
	//근형
	@Override
	public void addRep(BoardRepVO br) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("content", br.getContent());
		session.insert("com.developer.boardRep.addRep", param);
		session.close();
	}

	//근형
	@Override
	public void editRep(BoardRepVO br) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("content", br.getContent());
		param.put("date", br.getDate());
		param.put("postRepSeq", br.getPostRepSeq());
		session.update("com.developer.boardRep.editRep", param);
		session.commit();
		session.close();
	}

	//근형
	@Override
	public void delRep(int postRepSeq) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.developer.boardRep.delRep",postRepSeq);
		session.commit();
		session.close();
	}
	
}
