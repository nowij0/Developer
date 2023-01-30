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

public class EditHostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8888/Developer/hostuser/edithost
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		ObjectMapper mapper = new ObjectMapper();
		
		HostUserService service = new HostUserService();

//		HttpSession session = request.getSession(false);
//		String hostId = (String) session.getAttribute("loginId");
		String hostId = request.getParameter("hostId");
		String pwd = request.getParameter("pwd");
//		String num = request.getParameter("num");
//		int ready = Integer.parseInt(request.getParameter("ready"));
//		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		//이메일은 나중에 비밀번호찾기때문에 중복확인은 필요할듯
		String email = request.getParameter("email");
		try {
			service.editHost(new HostUserVO(hostId, pwd,"", 0, "", tel, email));
			
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
