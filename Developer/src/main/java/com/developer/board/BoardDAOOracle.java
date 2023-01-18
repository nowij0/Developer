package com.developer.board;

import java.util.Date;
import java.util.List;

import com.developer.exception.FindException;

public class BoardDAOOracle implements BoardDAO {

	@Override
	public List<BoardVO> selectAll() throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectInfo(int postSeq) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> BoardSearch(String title, int category) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> getByCondition(Date cDate, int cnt) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO selectByPostSeq(int postSeq) throws FindException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBoard(BoardVO b) throws FindException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBoard(BoardVO b) throws FindException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delBoard(int postSeq) throws FindException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardCnt(int cnt) throws FindException {
		// TODO Auto-generated method stub
		
	}

}
