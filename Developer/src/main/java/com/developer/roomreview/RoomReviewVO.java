package com.developer.roomreview;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class RoomReviewVO {
	private int reviewSeq;
	private String content;
	private int star;
	private Date cDate;
	private int resSeq;
	
	private RoomReviewVO roomReviewVO;
}
