package com.developer.lesson.vo;

import java.util.Date;
import java.util.List;

import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.favoriteslesson.vo.FavoritesLessonVO;
import com.developer.tutor.vo.TutorVO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
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
	private List<AppliedLessonVO> appliedLessonVO;
	private List<FavoritesLessonVO> favoritesLessonVO;
	public LessonVO(int lessonSeq, String userId, String lessonName, int category, String content, int people,
			String imgPath, Date startCdate, Date endCdate, int price, String location) {
		super();
		this.lessonSeq = lessonSeq;
		this.userId = userId;
		this.lessonName = lessonName;
		this.category = category;
		this.content = content;
		this.people = people;
		this.imgPath = imgPath;
		this.startCdate = startCdate;
		this.endCdate = endCdate;
		this.price = price;
		this.location = location;
	}
	
	
}
