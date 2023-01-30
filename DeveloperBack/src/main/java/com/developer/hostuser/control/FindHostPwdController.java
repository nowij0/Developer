package com.developer.hostuser.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.hostuser.service.HostUserService;
import com.developer.hostuser.vo.HostUserVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FindHostPwdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		HostUserService service = new HostUserService();
		String hostId = request.getParameter("hostId");
		String num = request.getParameter("num");
		String email = request.getParameter("email");
		HostUserVO vo = new HostUserVO();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			vo = service.selectHostPwd(hostId,num,email);
			String jsonStr = mapper.writeValueAsString(vo);
			if (vo != null) {
				return "비밀번호는 : " + jsonStr + "입니다.";
			} else {
				JOptionPane.showMessageDialog(null, "정보가 일치하지 않습니다!", "ERROR_MESSAGE",
						JOptionPane.ERROR_MESSAGE);
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
