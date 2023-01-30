package com.developer.boardrep.vo;

import java.util.Date;

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
