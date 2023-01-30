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

public class EditCafeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8888/Developer/studyroom/editcafe

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		ObjectMapper mapper = new ObjectMapper();

		StudyroomService service = new StudyroomService();

//		HttpSession session = request.getSession(false);
//		String hostId = (String) session.getAttribute("loginId");
		int srSeq = Integer.parseInt(request.getParameter("srSeq"));
		//String name = request.getParameter("name");
		//String addr = request.getParameter("addr");
		String info = request.getParameter("info");
		String openTime = request.getParameter("openTime");
		String endTime = request.getParameter("endTime");
		String imgPath = request.getParameter("imgPath");
		//int oc = Integer.parseInt(request.getParameter("oc"));
		//String hostId = request.getParameter("hostId");

		try {
			service.editCafe(new StudyroomVO(srSeq, "", "", info, openTime, endTime, imgPath, 0, ""));

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