package com.developer.appliedlesson;

import java.util.Date;
import java.util.List;

import com.developer.lesson.vo.LessonVO;
import com.developer.lessonreview.LessonReviewVO;
import com.developer.userreview.UserReviewVO;
import com.developer.users.UsersVO;

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
	private Date cdate;
	private int applyOk;
	
	private List<UsersVO> usersVO;
	private LessonVO lessonVO;
	private List<UserReviewVO> userReviewVO;
	private LessonReviewVO lessonReviewVO;
}
