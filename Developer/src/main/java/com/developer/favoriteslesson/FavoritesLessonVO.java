package com.developer.favoriteslesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@ToString

public class FavoritesLessonVO {
	private int favLesSeq;
	private String userId;
	private int lessonSeq;
	
	private LessonVO lessonVO;
}
