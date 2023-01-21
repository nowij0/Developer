package com.developer.reservation;

import java.util.Date;

import com.developer.hostuser.HostUserVO;
import com.developer.roominfo.RoomInfoVO;
import com.developer.studyroom.StudyroomVO;

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
	
	private StudyroomVO studyroomVO;
	private HostUserVO hostUserVO;	
}
