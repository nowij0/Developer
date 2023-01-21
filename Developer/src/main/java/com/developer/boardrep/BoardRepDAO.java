package com.developer.boardrep;

import java.util.List;

import com.developer.exception.FindException;

public interface BoardRepDAO {

//	Board에서 셀렉트문 합쳐서 한번에 출력
//	/**
//	 * <커뮤니티글 상세페이지> 댓글리스트 출력
//	 * @author choigeunhyeong
//	 * @param postSeq
//	 * @return 댓글전체
//	 * @throws FindException
//	 */
//	public List<BoardRepVO> selectAllRep(int postSeq) throws FindException;

	/**
	 * <커뮤니티글 상세페이지> 내댓글 검색
	 * @author choigeunhyeong
	 * @param postRepSeq 글번호
	 * @param userId 회원아이디
	 * @return 댓글
	 * @throws FindException
	 * 이부분 좀 헷갈려요! 필요한가 아닌가
	 */
//	public BoardRepVO selectByPostRepSeq(int postRepSeq, String userId) throws FindException;
	
	
	/**
	 * 
	 * <커뮤니티글 : 상세페이지> 댓글 작성
	 * @author choigeunhyeong
	 * @param br
	 * @throws FindException
	 */
	public void addRep(BoardRepVO br) throws FindException;
	
	/**
	 * <커뮤니티글 : 상세페이지> 댓글 수정
	 * @author choigeunhyeong
	 * @param br
	 * @throws FindException
	 */
	public void editRep(BoardRepVO br) throws FindException;
	
	/**
	 * <커뮤니티글 : 상세페이지> 댓글 삭제
	 * @author choigeunhyeong
	 * @param postRepSeq 삭제할 댓글 번호
	 * @throws FindException
	 */
	public void delRep(int postRepSeq) throws FindException;
	
	
	
	
}
