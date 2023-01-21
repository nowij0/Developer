package com.developer.hostuser;



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

public class HostUserVO {
	private String hostId;
	private String pwd;
	private String num;
	private int ready;
	private String name;
	private String tel;
	private String email;
	
	
}
