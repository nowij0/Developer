package com.developer.users.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.users.service.UsersService;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;


public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		UsersService service = new UsersService();
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		UsersVO vo = new UsersVO();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			vo = service.userLogin(userId, pwd);
			if(vo != null && pwd.equals(vo.getPwd())) {		
				HttpSession session = request.getSession();
				session.setAttribute("UserId", userId);//로그인 아이디
				session.setAttribute("role", vo.getRole());//로그인 사람의 타입
				String jsonStr = mapper.writeValueAsString(vo);
				return jsonStr;
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패!","ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			}
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
		
		return "/main.html";
	}

}
