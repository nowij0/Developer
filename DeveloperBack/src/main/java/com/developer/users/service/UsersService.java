package com.developer.users.service;

import com.developer.exception.FindException;
import com.developer.users.dao.UsersDAO;
import com.developer.users.dao.UsersDAOOracle;
import com.developer.users.vo.UsersVO;

public class UsersService {

	UsersDAO dao = new UsersDAOOracle();
	
	//JH
	public int joinUser(UsersVO vo) throws FindException{
		return dao.joinUsers(vo);
	}
	
	//JH
	public int updateUsers(UsersVO vo) throws FindException{
		return dao.updateUsers(vo);
	}
	
	//JH
	public UsersVO getUsers(String userId) throws FindException{
		return dao.getUsers(userId);
	}
	
	//JH
	public void deleteUser(String userId) throws FindException{
		dao.deleteUsers(userId);
	}
	
	//GH
	public UsersVO selectUserId(String email) throws FindException{
		return dao.selectUserId(email);
	}
	
	//GH
	public UsersVO selectUserPwd(String userId, String email) throws FindException{
		return dao.selectUserPwd(userId, email);
	}
	
	//GH
	public UsersVO userLogin(String userId, String pwd) throws FindException {
		return dao.userLogin(userId, pwd);
	}
	
}
