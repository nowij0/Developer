package com.developer.board.dao;

import java.util.List;

import com.developer.board.vo.BoardVO;
import com.developer.exception.FindException;

public interface BoardDAO {

	/**
	 * [커뮤니티 > 메인페이지] 게시판 테이블 글 전체목록 출력
	 * @author choigeunhyeong
	 * @param boardType(1번: 작성일최신순, 2번:조회수 높은순 3번: 추천높은순)
	 * @return BoardVO의 게시글 
	 * @throws FindException
	 */
	public List<BoardVO> selectBoardByType(int boardType) throws FindException;
	
	/**
	 * [커뮤니티 > 메인페이지] 게시글 하나에 대한 추천, 조회수, 댓글개수
	 * @author choigeunhyeong
	 * @param postSeq 글번호
	 * @return recommend, cnt, count(boardRep)
	 * @throws FindException
	 */
	public List<BoardVO> selectAllCnt(int postSeq) throws FindException;
	
	/**
	 * [커뮤니티 > 메인페이지] 제목으로 검색
	 * @author choigeunhyeong
	 * @param title 글제목
	 * @return 검색값을 포함하는 게시글
	 * @throws FindException
	 */
	public List<BoardVO> boardSearch(String title) throws FindException;
	
	/**
	 * [커뮤니티 > 글 상세페이지] 글의 상세정보 + 그 글의 댓글까지
	 * @author choigeunhyeong
	 * @param postSeq 글번호
	 * @return 글번호에 해당하는 상세정보
	 * @throws FindException
	 */
	public List<BoardVO> selectByPostSeq(int postSeq) throws FindException;
	
	/**
	 * [커뮤니티 > 글 상세페이지] 글 수정폼
	 * @author choigeunhyeong
	 * @param postSeq 글번호
	 * @return 글번호에해당하는 페이지내용
	 * @throws FindException
	 */
	public BoardVO selectBoardDetail(int postSeq) throws FindException;
	
	
	/**
	 * [커뮤니티 > 글 작성페이지] 글 작성
	 * @author choigeunhyeong
	 * @param b 작성할 값
	 * @throws FindException
	 */
	//public void addBoard(String userId, int category, String title, String content, String imgPath) throws FindException;
	public void addBoard(BoardVO vo) throws FindException;
	
	/**
	 * [커뮤니티 > 글 수정페이지] 글 수정
	 * @author choigeunhyeong
	 * @param b
	 * @throws FindException
	 */
	public void editBoard(BoardVO vo) throws FindException;
	
	
	/**
	 * [커뮤니티 > 글 상세페이지] 글 삭제
	 * @author choigeunhyeong
	 * @param postSeq 삭제할 글 번호
	 * @throws FindException
	 */
	public void delBoard(int postSeq) throws FindException;
	
//	/**
//	 * [커뮤니티 > 글 상세페이지] 글 조회시 로그인아이디가 추천했는지 여부확인
//	 * @author choigeunhyeong
//	 * @param postSeq 글번호
//	 * @return
//	 * @throws FindException
//	 */
//	public BoardVO checkRecommend(int postSeq) throws FindException;
	
	/**
	 * <커뮤니티 : 글 상세페이지> 글 조회시 조회수 증가
	 * @author choigeunhyeong
	 * @param postSeq
	 * @throws FindException
	 */
	public void updateCnt(int postSeq) throws FindException;
	
	/**
	 * [메인] 작성순으로 커뮤니티 글 5개만 출력한다.
	 * @author sr
	 * @return List<BoardVO>
	 * @throws FindException
	 */
	public List<BoardVO> boardSelectAllByDate() throws FindException;

}
