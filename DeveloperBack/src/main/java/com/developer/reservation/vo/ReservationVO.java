package com.developer.reservation.vo;

import java.sql.Date;
import java.util.List;

import com.developer.hostuser.vo.HostUserVO;
import com.developer.roomreview.vo.RoomReviewVO;
import com.developer.studyroom.vo.StudyroomVO;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.annotation.JsonFormat;

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
public class ReservationVO {
	private int resSeq;
	private String userId;
	private int roomSeq;
	private String startTime;
	private String endTime;
	@JsonFormat(pattern = "yyyy-mm-dd", timezone = "Asia/Seoul")
	private Date usingDate;
	private String hostId;

	private StudyroomVO studyroomVO; // sr추가: 해당 스터디카페 예약자명단 전체목록
	private UsersVO usersVO; // sr추가: 해당 스터디카페 예약자명단 전체목록
	private HostUserVO hostUserVO; // sr추가: 해당 스터디카페 예약자명단 전체목록
	private List<RoomReviewVO> roomReviewVO; //ds 추가
}
