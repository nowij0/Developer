package com.developer.userreview;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.developer.exception.FindException;
import com.developer.resource.Factory;

public class UserReviewDAOOracle implements UserReviewDAO {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserReviewDAOOracle() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	//장학
	@Override
	public List<UserReviewVO> getTuteeReview(String userId) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		List<UserReviewVO> list = session.selectList("com.developer.userreview.getTuteeReview", userId);

		return list;
	}	
	
	//장학
	@Override
	public int addTuteeReview(UserReviewVO vo) throws FindException {
		SqlSession session = sqlSessionFactory.openSession();
		int a = session.insert("com.developer.userreview.addTuteeReview",vo);
		session.commit();//커밋 필수....
		session.close();
		return  a;
	}	
	
	public static void main(String[] args) throws FindException {
		UserReviewDAOOracle dao = new UserReviewDAOOracle();
//		UserReviewVO vo = new UserReviewVO(7,5,"굳굳");
//		dao.addTuteeReview(vo);
//		System.out.println(vo);
//		List<UserReviewVO> list = dao.getTuteeReview("devman");
//		for(UserReviewVO v : list) {
//		System.out.println(v);
//		}

		
	}

}
