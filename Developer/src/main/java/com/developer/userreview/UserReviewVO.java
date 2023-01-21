package com.developer.userreview;

import com.developer.appliedlesson.AppliedLessonVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class UserReviewVO {

	private int applySeq;
	private int star;
	private String review;
	private AppliedLessonVO appliedLessonVO;
}
