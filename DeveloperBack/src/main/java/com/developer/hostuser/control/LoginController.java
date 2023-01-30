package com.developer.hostuser.control;

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
import com.developer.hostuser.service.HostUserService;
import com.developer.hostuser.vo.HostUserVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		HostUserService service = new HostUserService();
		String hostId = request.getParameter("hostId");
		String pwd = request.getParameter("pwd");
		HostUserVO vo = new HostUserVO();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			vo = service.hostLogin(hostId, pwd);
			if(vo != null && pwd.equals(vo.getPwd())) {		
				HttpSession session = request.getSession();
				session.setAttribute("hostId", hostId);//로그인 아이디
				session.setAttribute("ready", vo.getReady());
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
