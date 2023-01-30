package com.developer.studyroom;

import java.util.List;

import com.developer.favoritesstudyroom.FavoritesStudyroomVO;
import com.developer.hostuser.HostUserVO;
import com.developer.roominfo.RoomInfoVO;

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
	private int srSeq;
	private String name;
	private String addr;
	private String info;
	private String openTime;
	private String endTime;
	private String imgPath;
	private int oc;
	private String hostId;
	
	private String srNameAddrName;
	private int searchBy;
	private int orderBy;
	
	private FavoritesStudyroomVO favoritesStudyroomVO;
	private List<RoomInfoVO> roomInfoVO;
	private HostUserVO hostUserVO;
	
}