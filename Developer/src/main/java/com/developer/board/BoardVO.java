package com.developer.board;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private int post_seq;
	private String user_id;
	private int category;
	private String title;
	private String content;
	private String img_path;
	private String c_date;
	private String recommend;
	private int cnt;
	
	private UserVO userVO;
}
