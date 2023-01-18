package com.developer.roomreview;

import java.util.Date;

import com.developer.reservation.ReservationVO;

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

public class RoomReviewVO {
	private int reviewSeq;
	private String content;
	private int star;
	private Date cDate;
	private int resSeq;
	
	private String nickName;
	private String srName;
	private String riName;
	private ReservationVO reservationVO;
	
}
