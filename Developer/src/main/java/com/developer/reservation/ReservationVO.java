package com.developer.reservation;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class ReservationVO {
	private int res_seq;
	private String user_id;
	private int room_seq;
	private String start_time;
	private String end_time;
	private Date using_date;
	
	private RoomInfoVO roomInfoVO;
}
