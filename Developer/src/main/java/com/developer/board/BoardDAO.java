package com.developer.board;

import java.util.List;

import com.developer.exception.FindException;

public interface BoardDAO {
	
	/**
	 * [메인] 작성순으로 커뮤니티 글 5개만 출력한다.
	 * @author sr
	 * @return List<BoardVO>
	 * @throws FindException
	 */
	public List<BoardVO> boardSelectAllByDate() throws FindException;
}
