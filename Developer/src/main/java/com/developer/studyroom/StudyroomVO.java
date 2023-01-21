package com.developer.studyroom;

import com.developer.hostuser.HostUserVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudyroomVO {
	private int srSeq;
	private String name;
	private String addr;
	private String info;
	private String openTime;
	private String endTime;
	private String imgPath;
	private int oc;
	private String hostId;
	
	private int person;
	private int price;
	private String userId;
	
}