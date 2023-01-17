package com.developer.recommend;

import com.developer.board.BoardVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecommendVO {
	private int recSeq;
	private int postSeq;
	private String userId;

	private BoardVO boardVO;
}
