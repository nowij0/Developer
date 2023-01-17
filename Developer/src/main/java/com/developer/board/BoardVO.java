package com.developer.board;

import com.developer.users.UsersVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardVO {
	private int postSeq;
	private String userId;
	private int category;
	private String title;
	private String content;
	private String imgPath;
	private String cDate;
	private String recommend;
	private int cnt;
	
	private UsersVO usersVO;
}
 