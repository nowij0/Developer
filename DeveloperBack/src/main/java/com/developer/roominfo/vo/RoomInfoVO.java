package com.developer.roominfo.vo;

import com.developer.roomreview.RoomReviewVO;

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

public class RoomInfoVO {
	private int roomSeq;
	private int srSeq;
	private String name;
	private String info;
	private String imgPath;
	private int person;
	private int price;
	
	private RoomReviewVO roomReviewVO;
	
}
