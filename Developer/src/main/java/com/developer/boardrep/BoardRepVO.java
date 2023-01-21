package com.developer.boardrep;

import java.util.Date;

import com.developer.board.BoardVO;

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

public class BoardRepVO {
	private int postRepSeq;
	private String content;
	private Date date;
	private int postSeq;
	private String userId;
	
}
