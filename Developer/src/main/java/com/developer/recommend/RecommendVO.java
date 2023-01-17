package com.developer.recommend;

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
	private int rec_seq;
	private int post_seq;
	private String user_id;

	private BoardVO boardVO;
}
