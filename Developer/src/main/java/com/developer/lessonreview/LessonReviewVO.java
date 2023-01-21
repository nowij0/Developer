package com.developer.lessonreview;

import java.util.Date;

import com.developer.appliedlesson.AppliedLessonVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class LessonReviewVO {
	private int leRevSeq;
	private int applySeq;
	private Date cDate;
	private String review;
	private int star;
	
}
