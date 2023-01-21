package com.developer.roominfo;

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
}
