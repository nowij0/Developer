package com.developer.users.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.users.service.UsersService;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateUsersController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
//		SET pwd=#{pwd}, nickname=#{nickname}, name=#{name},
//				email=#{email}, tel=#{tel}, 
//				addr=#{addr}  WHERE user_id=#{userId}		
		ObjectMapper mapper = new ObjectMapper();
		UsersService service = new UsersService();
		
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		try {
			service.updateUsers(new UsersVO(userId, 0, pwd, nickname, name, email, tel, addr));
			
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
		return null;
	
		
	}

}