package com.developer.boardrep.service;

import com.developer.boardrep.dao.BoardRepDAO;
import com.developer.boardrep.dao.BoardRepDAOOracle;
import com.developer.boardrep.vo.BoardRepVO;
import com.developer.exception.FindException;

public class BoardRepService {
	
	private BoardRepDAO dao = new BoardRepDAOOracle();
	
	public void addRep(BoardRepVO br) throws FindException{
		dao.addRep(br);
	}
	
	public void editRep(BoardRepVO br) throws FindException{
		dao.editRep(br);
	}
	
	public void delRep(int postRepSeq) throws FindException{
		dao.delRep(postRepSeq);
	}
}
