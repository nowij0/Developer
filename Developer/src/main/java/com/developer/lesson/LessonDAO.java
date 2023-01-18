package com.developer.lesson;

import java.util.List;

import com.developer.exception.FindException;

public interface LessonDAO {

	
	/**
	 * [메인] 날짜가 임박한순으로 수업 전체 목록을 출력한다.
	 * @author sr
	 * @return List<LessonVO>
	 * @throws FindException
	 */
	public List<LessonVO> selectAllByDate() throws FindException; 


}
