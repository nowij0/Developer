package com.developer.boardrep;

import java.util.Date;

import com.developer.tutor.TutorVO;

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
	private Date cDate;
	private int postSeq;
	private String userId;
	
	private BoardVO boardVO;
	
}
