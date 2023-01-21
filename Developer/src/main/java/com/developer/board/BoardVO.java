package com.developer.board;


import java.util.Date;
import java.util.List;

import com.developer.board.recommend.RecommendVO;
import com.developer.boardrep.BoardRepVO;
import com.developer.users.UsersVO;
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
@JsonFormat(pattern = "yyyy-mm-dd", timezone = "Asia/Seoul")

public class BoardVO {
	private int postSeq;
	private String userId;
	private int category;
	private String title;
	private String content;
	private String imgPath;
	private Date cDate;
	private int recommend;
	private int cnt;
	private int boardType=1; //1번: 작성일최신순, 2번:조회수 높은순 3번: 추천높은순
	
	private UsersVO usersVO;
	private List<RecommendVO> recommendVO;
	private List<BoardRepVO> boardRepVO;
	
}
 