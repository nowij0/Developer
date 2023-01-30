package com.developer.appliedlesson.vo;

import java.util.Date;
import java.util.List;

import com.developer.lesson.vo.LessonVO;
import com.developer.lessonreview.vo.LessonReviewVO;
import com.developer.userreview.vo.UserReviewVO;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class AppliedLessonVO {
	
	private int applySeq;
	private int lessonSeq;
	private String userId;
	@JsonFormat(pattern = "yy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
	private Date cdate;
	private int applyOk;
	
	private List<UsersVO> usersVO;
	private LessonVO lessonVO;
	private List<UserReviewVO> userReviewVO;
	private LessonReviewVO lessonReviewVO;
}
