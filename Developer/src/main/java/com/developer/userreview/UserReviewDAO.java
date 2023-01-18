package com.developer.userreview;

import com.developer.exception.FindException;

public interface UserReviewDAO {
	/**
	 * <일반회원 : 마이페이지 > 튜터의 튜티에 관한 후기 작성
	 * @author choigeunhyeong
	 * @param 작성한 후기를 담을 vo객체
	 * @throws FindException
	 */
	public void addUserReivew(UserReviewVO vo) throws FindException;
	
}
