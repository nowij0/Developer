package com.developer.board;

import java.util.Date;
import java.util.List;

import com.developer.exception.FindException;

public interface BoardDAO {
	
	/**
	 * <커뮤니티 : 메인페이지> 게시판 테이블 글 전체목록 출력
	 * @author choigeunhyeong
	 * @return BoardVO 
	 * @throws FindException
	 */
	public List<BoardVO> selectAll() throws FindException;
	
	/**
	 * <커뮤니티 : 메인페이지> 게시글 하나에 대한 추천, 조회수, 댓글개수
	 * @author choigeunhyeong
	 * @param postSeq 글번호
	 * @return recommend, cnt, count(boardRep)
	 * @throws FindException
	 */
	public List<BoardVO> selectInfo(int postSeq) throws FindException;
	
	/**
	 * <커뮤니티 : 메인페이지> 제목 혹은 카테고리로 검색
	 * @author choigeunhyeong
	 * @param title 글제목
	 * @param category 카테고리
	 * @return 검색값을 포함하는 게시글
	 * @throws FindException
	 */
	public List<BoardVO> BoardSearch(String title, int category) throws FindException;
	
	/**
	 * <커뮤니티 : 메인페이지>게시글 정렬(날짜순, 조회순, ..)
	 * @author choigeunhyeong
	 * @return BoardVO
	 * @throws FindException
	 * 정렬 cDate 높고낮은순, cnt 높고낮은순.. 파라메터로,, 상세한 정렬조건은 맴퍼에서 ?
	 */
	public List<BoardVO> getByCondition(Date cDate, int cnt) throws FindException;
	
	/**
	 * <커뮤니티 : 글 상세페이지> 글의 상세정보 
	 * @author choigeunhyeong
	 * @param postSeq 글번호
	 * @return 글번호에 해당하는 상세정보
	 * @throws FindException
	 */
	public BoardVO selectByPostSeq(int postSeq) throws FindException;
	
	/**
	 * <커뮤니티 : 글 작성페이지> 글 작성
	 * @author choigeunhyeong
	 * @param b 작성할 값
	 * @throws FindException
	 */
	public void addBoard(BoardVO b) throws FindException;
	
	/**
	 * <커뮤니티 : 글 수정페이지> 글 수정
	 * @author choigeunhyeong
	 * @param b
	 * @throws FindException
	 */
	public void editBoard(BoardVO b) throws FindException;
	
	/**
	 * <커뮤니티 : 글 상세페이지> 글 삭제
	 * @author choigeunhyeong
	 * @param postSeq 삭제할 글 번호
	 * @throws FindException
	 */
	public void delBoard(int postSeq) throws FindException;
	
	/**
	 * <커뮤니티 : 글 상세페이지> 글 조회시 조회수 증가
	 * @author choigeunhyeong
	 * @param cnt
	 * @throws FindException
	 */
	public void boardCnt(int cnt) throws FindException;
}
