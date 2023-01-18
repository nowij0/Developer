package com.developer.lesson;

import java.util.Date;

import com.developer.tutor.TutorVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class LessonVO {

	private int lessonSeq;
	private String userId;
	private String lessonName;
	private int category;
	private String content;
	private int people;
	private String imgPath;
	private Date startCdate;
	private Date endCdate;
	private int price;
	private Date startDate;
	private Date endDate;
	private int payLesson;
	private String location;
	
	private TutorVO tutorVO;
	
	//Users 테이블 
	private String name;
	
	//Applied_Lesson 테이블 
	private int applySeq;
	private int applyOk;
	
	//Lesson_Review 테이블 
	private String review;
	private int star;
	
	private int filter;
}
