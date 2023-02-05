package com.developer.studyroom.vo;

import java.util.List;

import com.developer.favoritesstudyroom.vo.FavoritesStudyroomVO;
import com.developer.hostuser.vo.HostUserVO;
import com.developer.roominfo.vo.RoomInfoVO;

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
	
	private List<RoomInfoVO> roomInfoVO;
	private HostUserVO hostUserVO;
	private String srNameAddrName;
	private int searchBy;
	private int person;
	private int orderBy;
	private FavoritesStudyroomVO favoritesStudyroomVO;
	
	//sr: 카페등록때 필요한 생성자(has-a관계 제외하고)
	public StudyroomVO(int srSeq, String name, String addr, String info, String openTime, String endTime,
			String imgPath, int oc, String hostId) {
		super();
		this.srSeq = srSeq;
		this.name = name;
		this.addr = addr;
		this.info = info;
		this.openTime = openTime;
		this.endTime = endTime;
		this.imgPath = imgPath;
		this.oc = oc;
		this.hostId = hostId;
	}
	
	
}