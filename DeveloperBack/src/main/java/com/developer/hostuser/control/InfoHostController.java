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

public class InfoHostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8888/Developer/hostuser/infohost
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		String hostId = request.getParameter("hostId");

//		HttpSession session = request.getSession(false);
//		String hostId = (String) session.getAttribute("loginId");
		HostUserService service = new HostUserService();
		ObjectMapper mapper = new ObjectMapper();

		try {
			HostUserVO vo = service.infoHostUser(hostId);
			String jsonStr = mapper.writeValueAsString(vo);
			return jsonStr;

		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}

	}

}
