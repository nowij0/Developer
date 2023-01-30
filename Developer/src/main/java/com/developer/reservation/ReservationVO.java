package com.developer.reservation;

import java.util.Date;
import java.util.List;

import com.developer.hostuser.HostUserVO;
import com.developer.roomreview.RoomReviewVO;
import com.developer.studyroom.StudyroomVO;
import com.developer.users.UsersVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class ReservationVO {
	private int resSeq;
	private String userId;
	private int roomSeq;
	private String startTime;
	private String endTime;
	private Date usingDate;
	private String hostId;
	
	private UsersVO usersVO;
	private StudyroomVO studyroomVO;
	private List<RoomReviewVO> roomReviewVO;
	private HostUserVO hostUserVO;	

}
