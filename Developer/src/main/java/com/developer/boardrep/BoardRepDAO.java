package com.developer.boardrep;

import java.util.List;

import com.developer.exception.FindException;

public interface BoardRepDAO {
	
	/**
	 * <커뮤니티글 상세페이지> 댓글리스트 출력
	 * @author choigeunhyeong
	 * @param postSeq 게시글에 대한 댓글..이니까?
	 * @return 댓글전체
	 * @throws FindException
	 */
	public List<BoardRepVO> selectAllRep(int postSeq) throws FindException;

	/**
	 * <커뮤니티글 상세페이지> 내댓글 검색을위한 메서드
	 * @author choigeunhyeong
	 * @param postRepSeq 글번호
	 * @param userId 회원아이디
	 * @return 댓글
	 * @throws FindException
	 * 이부분 좀 헷갈려요!
	 */
	
//	public BoardRepVO selectByPostRepSeq(int postRepSeq, String userId) throws FindException;
	/**
	 * <커뮤니티글 : 상세페이지> 댓글 작성
	 * @author choigeunhyeong
	 * @param vo
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
