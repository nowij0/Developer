package com.developer.studyroom.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.studyroom.service.StudyroomService;
import com.developer.studyroom.vo.StudyroomVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddCafeController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// http://localhost:8888/Developer/studyroom/addcafe
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String info = request.getParameter("info");
		String openTime = request.getParameter("openTime");
		String endTime = request.getParameter("endTime");
		String imgPath = request.getParameter("imgPath");
		int oc = Integer.parseInt(request.getParameter("oc"));
		// 참조키 호스트 아이디는 로그인세션에서..받아올!
//		HttpSession session = request.getSession(false);
//		String hostId = (String) session.getAttribute("loginId");

		String hostId = request.getParameter("hostId");
		StudyroomService service = new StudyroomService();
		ObjectMapper mapper = new ObjectMapper();
		try {                            //nextval은 0으로?
			service.addCafe(new StudyroomVO(0, name, addr, info, openTime, endTime, imgPath, oc, hostId));
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
