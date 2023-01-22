package com.developer.lesson.vo;

import java.util.Date;
import java.util.List;

import com.developer.appliedlesson.AppliedLessonVO;
import com.developer.favoriteslesson.FavoritesLessonVO;
import com.developer.tutor.TutorVO;
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
}
