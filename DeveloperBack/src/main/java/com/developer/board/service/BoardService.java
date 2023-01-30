package com.developer.board.service;

import java.util.List;

import com.developer.board.dao.BoardDAO;
import com.developer.board.dao.BoardDAOOracle;
import com.developer.board.vo.BoardVO;
import com.developer.exception.FindException;

public class BoardService {
	
	BoardDAO dao = new BoardDAOOracle();
	
	//GH
	public List<BoardVO> selectBoardByType(int boardType) throws FindException{
		return dao.selectBoardByType(boardType);
	}
	
	//GH
	public List<BoardVO> selectAllCnt(int postSeq) throws FindException{
		return dao.selectAllCnt(postSeq);
	}
	
	//GH
	public List<BoardVO> boardSearch(String title) throws FindException{
		return dao.boardSearch(title);
	}
	
	//GH
	public List<BoardVO> selectByPostSeq(int postSeq) throws FindException{
		return dao.selectByPostSeq(postSeq);
	}
	
	//GH
	public BoardVO selectBoardDetail(int postSeq) throws FindException{
		return dao.selectBoardDetail(postSeq);
	}
	
	//GH
	public void addBoard(BoardVO vo) throws FindException{
		dao.addBoard(vo);
	}
	
	//GH
	public void editBoard(BoardVO vo) throws FindException{
		dao.editBoard(vo);
	}
	
	//GH
	public void delBoard(int postSeq) throws FindException{
		dao.delBoard(postSeq);
	}
	
	//GH
	public void updateCnt(int postSeq) throws FindException{
		dao.updateCnt(postSeq);
	}
	
	//sr: 메인페이지 날짜순출력
	public List<BoardVO> listBoardByDate() throws FindException{
		return dao.boardSelectAllByDate();
	}
}
