package com.developer.hostuser.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.hostuser.service.HostUserService;
import com.developer.hostuser.vo.HostUserVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JoinHostUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		HostUserService service = new HostUserService();
		
		String hostId = request.getParameter("hostId");
		String pwd = request.getParameter("pwd");
		String num = request.getParameter("num");
//		int ready = Integer.parseInt(request.getParameter("ready"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		HostUserVO vo = new HostUserVO(hostId, pwd, num, 0, name, tel, email);
		
		try {
			int check;
			check = service.joinHostUser(vo);
			System.out.println(check);
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
