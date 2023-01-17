package com.developer.lessonreivew;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class LessonReivewVO {
	private int leRevSeq;
	private int applySeq;
	private Date cdate;
	private String reivew;
	private int star;
	
//	private LessonVO lessonVO;
	
}
