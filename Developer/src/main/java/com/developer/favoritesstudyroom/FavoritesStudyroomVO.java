package com.developer.favoritesstudyroom;

import com.developer.studyroom.StudyroomVO;

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

public class FavoritesStudyroomVO {
	private int favSeq;
	private int srSeq;
	private String userId;
	private int cnt;
	
	private StudyroomVO studyroomVO; 
}
