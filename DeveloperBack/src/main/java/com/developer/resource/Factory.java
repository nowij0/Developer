package com.developer.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//DAO를 구현하는 객체
public class Factory {
	private static SqlSessionFactory sqlSessionFactory;
	// 초기화 블록:멤버 변수 초기화하는 블록
	static {
		try {
			String resource = "config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);

			if (sqlSessionFactory == null) {
				//사용할 sqlSessionFactory 객체 생성
				//	Builder :  객체 생성에 필요한 설정이 가능하고, 설정한 내용으로 객체를 생성해줌
				//	build(): config.xml 의 내용을 설정에 활용하여 설정
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory; //sqlSessionFactory 객체를 return
	}
}