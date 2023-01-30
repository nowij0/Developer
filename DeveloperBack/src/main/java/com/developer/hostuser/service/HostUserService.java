package com.developer.hostuser.service;

import com.developer.exception.FindException;
import com.developer.hostuser.dao.HostUserDAO;
import com.developer.hostuser.dao.HostUserDAOOracle;
import com.developer.hostuser.vo.HostUserVO;

public class HostUserService {

	HostUserDAO dao = new HostUserDAOOracle();
	
	// sr: 호스트 마이페이지(호스트정보출력)
	public HostUserVO infoHostUser(String hostId) throws FindException {
		return dao.getHostUser(hostId);
	}

	// sr: 호스트 마이페이지(호스트정보수정)
	public int editHost(HostUserVO hostUserVO) throws FindException {
		int a = dao.updateHostUser(hostUserVO);
		return a;
	}

	// sr: 호스트 마이페이지(호스트 탈퇴)
	public int outHostUser(String hostId) throws FindException {
		int a = dao.deleteHostUser(hostId);
		return a;
	}
	
	//JH
	public int joinHostUser(HostUserVO vo) throws FindException{
		return dao.joinHostUser(vo);
	}
	
	//GH
	public HostUserVO hostLogin(String userId, String pwd) throws FindException{
		return dao.hostLogin(userId, pwd);
	}
	
	//GH
	public HostUserVO selectHostId(String email) throws FindException{
		return dao.selectHostId(email);
	}
	
	//GH
	public HostUserVO selectHostPwd(String userId, String num, String email) throws FindException{
		return dao.selectHostPwd(userId, num, email);
	}

}
