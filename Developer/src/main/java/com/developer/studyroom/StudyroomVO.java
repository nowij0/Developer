package com.developer.studyroom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudyroomVO {
	private int sr_seq;
	private String name;
	private String addr;
	private String info;
	private String open_time;
	private String end_time;
	private String img_path;
	private int ov;
	private String host_id;
	
	
	private Host_userVO host_userVO;
	
}
