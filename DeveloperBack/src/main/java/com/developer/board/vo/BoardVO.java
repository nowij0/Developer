package com.developer.board.vo;

import java.sql.Date;
import java.util.List;

import com.developer.boardrep.vo.BoardRepVO;
import com.developer.recommend.vo.RecommendVO;
import com.developer.users.vo.UsersVO;
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
	private int postSeq;
	private String userId;
	private int category; //0:Q/A,  1:스터디모집,  2:자유 게시판
	private String title;
	private String content;
	private String imgPath;
	private Date cDate;
	@JsonFormat(pattern = "yyyy-mm-dd", timezone = "Asia/Seoul")
	private int recommend;
	private int cnt;
	private int boardType=1; //1번: 작성일최신순, 2번:조회수 높은순 3번: 추천높은순
	
	private UsersVO usersVO;
	private List<RecommendVO> recommendVO;
	private List<BoardRepVO> boardRepVO;
	
	public BoardVO(int postSeq, String userId, int category, String title, String content, String imgPath, Date cDate,
			int recommend, int cnt) {
		super();
		this.postSeq = postSeq;
		this.userId = userId;
		this.category = category;
		this.title = title;
		this.content = content;
		this.imgPath = imgPath;
		this.cDate = cDate;
		this.recommend = recommend;
		this.cnt = cnt;
	}
	
}
 